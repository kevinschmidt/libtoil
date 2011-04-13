package org.libtoil.core;

import java.util.Iterator;

import net.jimblackler.Utils.CollectionAbortedException;
import net.jimblackler.Utils.Collector;
import net.jimblackler.Utils.ResultHandler;
import net.jimblackler.Utils.ThreadedYieldAdapter;

public class TemplateTokenizer {
	char[] src;
	public enum TokenType {
		EOL,
		LITERALAT,
		WHITESPACE,
		TEXTLITERAL, 
		LINECONTINUATION, 
		COMMENT, 
		COMMAND,
		TEMPLATE,
		LINE
	}

	TemplateTokenizer(char[] src) {
		this.src = src;
	}
	
	TemplateTokenizer(String srcString) {
		this.src = srcString.toCharArray();
	}
	
	public SyntaxTreeNode parseTree() {
		Iterator<Token> it = TemplateTokenizerModifier.getTokens(this);
		it = LineContRemovalModifier.getTokens(this, it);
		it = NoOperationModifier.getTokens(this, it);
		it = InsertStartTokenModfier.getTokens(this, it);
		
		if (!it.hasNext()) {
			throw new TemplateParseError("Tokenizer failure", src, 0);
		}
		SyntaxTreeNode root = new SyntaxTreeNode(it.next());
		SyntaxTreeNode line = null;
		while (it.hasNext()) {
			Token t = it.next();
			if (t.type == TokenType.LINE) {
				line = new SyntaxTreeNode(t);
				root.addChild(line);
			} else {
				line.addChild(new SyntaxTreeNode(t));
			}
			
		}
		return root;
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
	
	public static class TemplateTokenizerModifier {

	    public static Iterator<Token> getTokens(final TemplateTokenizer tt) {
	        return new ThreadedYieldAdapter<Token>().adapt(new Collector<Token>() {
	            public void collect(ResultHandler<Token> resultHandler) throws
	                    CollectionAbortedException {
	            	process(tt, resultHandler);
	            }
	        }).iterator();
	    }
		
		public static void process(TemplateTokenizer tt, ResultHandler<Token> handler) throws CollectionAbortedException {
			int start = 0;
			do {
				Token t = tt.new Token(null, start, start);
				char c;
				do {
					c = (t.end < tt.src.length) ? tt.src[t.end] : 0;
					t.end++;
				} while (!classify(t, c));
				handler.handleResult(t);
				start = t.end;
			} while (start < tt.src.length);
		}
		
		/**
		 * Called for each character to be 
		 * @param t the Token currently being processed.  
		 * @param c the current character being read from the template source
		 * @return  true if the Token is complete
		 */
		private static boolean classify(Token t, char c) {
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
		
		private static boolean classifyLiteralAt(Token t, char c) {
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

		private static boolean classifyComment(Token t, char c) {
			if (c == '\n' || c == 0) {
				t.end--;
				return true;
			} 
			return false;
		}
		
		private static boolean classifyWhitespace(Token t, char c) {
			if (c == '\n' || !Character.isWhitespace(c) || c == 0) {
				t.end--;
				return true;
			} 
			return false;
		}
		
		private static boolean classifyTextLiteral(Token t, char c) {
			if (Character.isWhitespace(c) || c == '@' || c == 0) {
				t.end--;
				return true;
			} 
			return false;
		}
		
		private static boolean classifyCommand(Token t, char c) {
			if (Character.isWhitespace(c) || c == 0) {
				t.end = t.start + 1;
				t.type = TokenType.LITERALAT;
				return true;
			} else if (c == '@') {
				return true;
			}
			return false;
		}
		
		private static boolean classifyNull(Token t, char c) {
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
	
	public static class LineContRemovalModifier {
	    public static Iterator<Token> getTokens(final TemplateTokenizer tt, final Iterator<Token> it) {
	        return new ThreadedYieldAdapter<Token>().adapt(new Collector<Token>() {
	            public void collect(ResultHandler<Token> resultHandler) throws
	                    CollectionAbortedException {
	            	process(tt, it, resultHandler);
	            }
	        }).iterator();
	    }

		public static void process(
				TemplateTokenizer tt, Iterator<Token> it, ResultHandler<Token> handler)
				throws CollectionAbortedException {
			while (it.hasNext()) {
				Token t = it.next();
				if (t.type == TokenType.LINECONTINUATION) {
					Token continuationToken = t;
					do {
						if (!it.hasNext()) {
							throw new TemplateParseError("Invalid line continuation", tt.src, continuationToken.start);
						}
						t = it.next();
					} while (t.type == TokenType.WHITESPACE);
					if (t.type != TokenType.EOL) {
						throw new TemplateParseError("Invalid line continuation", tt.src, continuationToken.start);
					}
					if (!it.hasNext()) {
						throw new TemplateParseError("Invalid line continuation", tt.src, continuationToken.start);
					}
				} else {
					handler.handleResult(t);
				}
			}
		}
	}

	public static class NoOperationModifier {
	    public static Iterator<Token> getTokens(final TemplateTokenizer tt, final Iterator<Token> it) {
	        return new ThreadedYieldAdapter<Token>().adapt(new Collector<Token>() {
	            public void collect(ResultHandler<Token> resultHandler) throws
	                    CollectionAbortedException {
	            	process(tt, it, resultHandler);
	            }
	        }).iterator();
	    }
	    
		public static void process(
				TemplateTokenizer tt, Iterator<Token> it, ResultHandler<Token> handler)
				throws CollectionAbortedException {
			while (it.hasNext()) {
				handler.handleResult(it.next());
			}

		}
	}

	public static class InsertStartTokenModfier {
	    public static Iterator<Token> getTokens(final TemplateTokenizer tt, final Iterator<Token> it) {
	        return new ThreadedYieldAdapter<Token>().adapt(new Collector<Token>() {
	            public void collect(ResultHandler<Token> resultHandler) throws
	                    CollectionAbortedException {
	            	process(tt, it, resultHandler);
	            }
	        }).iterator();
	    }

		public static void process(TemplateTokenizer tt, Iterator<Token> it,
				ResultHandler<Token> handler) throws CollectionAbortedException {
			handler.handleResult(tt.new Token(TokenType.TEMPLATE, 0, 0));
			handler.handleResult(tt.new Token(TokenType.LINE, 0, 0));
			while (it.hasNext()) {
				Token t = it.next();
				handler.handleResult(t);
				if (t.type == TokenType.EOL) {
					handler.handleResult(tt.new Token(TokenType.LINE, t.end, t.end));
				}
			}
		}
	}
}
