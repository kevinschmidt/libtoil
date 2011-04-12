package org.libtoil.core;

import java.util.Iterator;

import net.jimblackler.Utils.CollectionAbortedException;
import net.jimblackler.Utils.Collector;
import net.jimblackler.Utils.ResultHandler;
import net.jimblackler.Utils.ThreadedYieldAdapter;

public class TemplateTokenizer implements Iterable<TemplateTokenizer.Token> {
	char[] src;
	public enum TokenType {
		EOL,
		LITERALAT,
		WHITESPACE,
		TEXTLITERAL, 
		LINECONTINUATION, 
		COMMENT, 
		COMMAND,
	}

	TemplateTokenizer(char[] src) {
		this.src = src;
	}
	
	TemplateTokenizer(String srcString) {
		this.src = srcString.toCharArray();
	}
	
	public Iterator<Token> iterator() {
		Collector<Token> coll = new TemplateTokenizerCollector(src);
		Iterator<Token> it = new ThreadedYieldAdapter<Token>().adapt(coll).iterator();
		coll = new LineContRemovalCollector(it);
		it = new ThreadedYieldAdapter<Token>().adapt(coll).iterator();
		return it;
	}
	
	public class TemplateTokenizerCollector implements Collector<Token> {
		char[] src;
		
		TemplateTokenizerCollector(char[] src) {
			this.src = src;
		}
		
		public void collect(ResultHandler<Token> handler) throws CollectionAbortedException {
			int start = 0;
			do {
				Token t = new Token(null, start, start);
				char c;
				do {
					c = (t.end < src.length) ? src[t.end] : 0;
					t.end++;
				} while (!classify(t, c));
				handler.handleResult(t);
				start = t.end;
			} while (start < src.length);
		}
		
		boolean classify(Token t, char c) {
			if (t.type == TokenType.LITERALAT) {
				return classifyLiteralAt(t, c);
			} else if (t.type == TokenType.COMMENT) {
				return classifyComment(t, c);
			} else if (t.type == TokenType.WHITESPACE) {
				return classifyWhitespace(t, c);
			} else if (t.type == TokenType.TEXTLITERAL) {
				return classifyTextLiteral(t, c);
			} else if (t.type == TokenType.COMMAND) {
				return classifyCommand(t, c);
			} else if (t.type == null) { 
				return classifyNull(t, c);
			} else {
				throw new RuntimeException("unreachable code");
			}
		}
		
		boolean classifyLiteralAt(Token t, char c) {
			if (c == '#') {
				t.type = TokenType.COMMENT;
			} else if (c == '@') {
				return true;
			} else if (Character.isWhitespace(c) || c == '\n' || c == 0) {
				t.end--;
				return true;
			} else if (c == '\\') {
				t.type = TokenType.LINECONTINUATION;
				return true;
			} else {
				t.type = TokenType.COMMAND;
			}
			return false;
		}

		boolean classifyComment(Token t, char c) {
			if (c == '\n' || c == 0) {
				t.end--;
				return true;
			} 
			return false;
		}
		
		boolean classifyWhitespace(Token t, char c) {
			if (c == '\n' || !Character.isWhitespace(c) || c == 0) {
				t.end--;
				return true;
			} 
			return false;
		}
		
		boolean classifyTextLiteral(Token t, char c) {
			if (Character.isWhitespace(c) || c == '@' || c == 0) {
				t.end--;
				return true;
			} 
			return false;
		}
		
		boolean classifyCommand(Token t, char c) {
			if (Character.isWhitespace(c) || c == 0) {
				t.end = t.start + 1;
				t.type = TokenType.LITERALAT;
				return true;
			} else if (c == '@') {
				return true;
			}
			return false;
		}
		
		boolean classifyNull(Token t, char c) {
			if (c == '\n') {
				t.type = TokenType.EOL;
				t.end = t.start + 1;
				return true;
			} else if (c == '@') {
				t.type = TokenType.LITERALAT;
			} else if (Character.isWhitespace(c)) {
				t.type = TokenType.WHITESPACE;
			} else {
				t.type = TokenType.TEXTLITERAL;
			}
			return false;
		}
	}
	
	public class LineContRemovalCollector implements Collector<Token> { 
		Iterator<Token> it;

		public LineContRemovalCollector(Iterator<Token> it) {
			this.it = it;
		}

		public void collect(ResultHandler<Token> handler) throws CollectionAbortedException {
			while (it.hasNext()) {
				Token t = it.next();
				if (t.type == TokenType.LINECONTINUATION) {
					Token continuationToken = t;
					do {
						if (!it.hasNext()) {
							throw new TemplateParseError("Invalid line continuation", src, continuationToken.start);
						}
						t = it.next();
					} while (t.type == TokenType.WHITESPACE);
					if (t.type != TokenType.EOL) {
						throw new TemplateParseError("Invalid line continuation", src, continuationToken.start);
					}
					if (!it.hasNext()) {
						throw new TemplateParseError("Invalid line continuation", src, continuationToken.start);
					}
				} else {
					handler.handleResult(t);
				}
			}
		}
	}
	
	public class Token {
		public TokenType type;
		public int start, end;
		
		public Token(TokenType type, int start, int end) {
			this.type = type;
			this.start = start;
			this.end = end;
		}
		
		public char[] getSource() {
			return src;
		}
		
		public String toString() {
			return new String(src, start, end-start);
		}
	}


}
