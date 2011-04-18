package org.libtoil.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;

public class TemplateTokenizer {
	char[] src;
	public enum TokenType {
		EOL,
		LITERALAT,
		WHITESPACE,
		TEXTLITERAL, 
		LINECONTINUATION, 
		COMMENT, 
		STATEMENT,
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
		List<Token> l = parseTokens();
		l = removeLineContinuations(l);
		l = insertStartTokens(l);
		SyntaxTreeNode root = null;
		SyntaxTreeNode line = null;
		for (Token t: l) {
			if (t.type == TokenType.TEMPLATE) {
				root = new SyntaxTreeNode(t);
			} else if (t.type == TokenType.LINE) {
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
		
		char nextChar() {
			if (end < src.length) {
				return src[end++];
			} else {
				end++;
				return 0;
			}
		}
		
		public char[] getSource() {
			return src;
		}
		
		public String toString() {
			return new String(src, start, end-start);
		}
	}
	
	List<Token> parseTokens() {
		List<Token> result = new ArrayList<Token>();
		int start = 0;
		do {
			Token t = new Token(null, start, start);
			char c;
			do {
				c = t.nextChar();
			} while (!classify(t, c));
			result.add(t);
			start = t.end;
		} while (start < src.length);
		return result;
	}

	 class TokenInterator implements Iterator<Token> {
		int pos;
		public boolean hasNext() {
			return pos < src.length;
		}

		private char nextChar() {
			if (pos < src.length) {
				return src[pos++];
			} else {
				pos++;
				return 0;
			}
		}
		
		public Token next() {
			int start = pos;
			char c = nextChar();
			if (c == '\n') {
				return new Token(TokenType.EOL, start, pos);
			} else if (c == '@') {
				return parseLiteralAt(start, nextChar());
			} else if (Character.isWhitespace(c)) {
				return parseWhitespace(start, nextChar());
			} else {
				return parseText(start, nextChar());
			}
		}
		
		private Token parseWhitespace(int start, char c) {
			while (c != '\n' && Character.isWhitespace(c)) {
				c = nextChar();
			}
			return new Token(TokenType.WHITESPACE, start, --pos);
		}
		
		private Token parseText(int start, char c) {
			while (!Character.isWhitespace(c) && c != '@' && c!= 0) {
				c = nextChar();
			}
			return new Token(TokenType.TEXTLITERAL, start, --pos);
		}
		
		private Token parseLiteralAt(int start, char c) {
			if (c == '#') {
				return parseComment(start, nextChar());
			} else if (c == '@') {
				return new Token(TokenType.LITERALAT, start, pos);
			} else if (Character.isWhitespace(c) || c == '\n' || c == 0) {
				return new Token(TokenType.LITERALAT, start, --pos);
			} else if (c == '\\') {
				return parseLineContinuation(start, nextChar());
			} else {
				return parseStatement(start);
			}
		}
		
		private Token parseStatement(int start) {
			return null;
		}
		
		private Token parseComment(int start, char c) {
			while (c != '\n' && c != 0) {
				c = nextChar();
			}
			return new Token(TokenType.LITERALAT, start, --pos);
		}

		private Token parseLineContinuation(int start, char c) {
			while (c != '\n' && Character.isWhitespace(c)) {
				c = nextChar();
			}
			if (nextChar() == '\n') { 
				return new Token(TokenType.LITERALAT, start, --pos);
			} else {
				throw new TemplateParseError("Invalid line continuation", src, start);
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
		
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
		} else if (t.type == TokenType.STATEMENT) {
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
			t.type = TokenType.STATEMENT;
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
	
	
	List<Token> removeLineContinuations(List<Token> l) {
		List<Token> result = new ArrayList<Token>();
		Iterator<Token> it = l.iterator();
		while (it.hasNext()) {
			Token t = it.next();
			if (t.type == TokenType.LINECONTINUATION) {
				Token continuationToken = t;
				do {
					if (!it.hasNext()) {
						throw new TemplateParseError(
				"Invalid line continuation", src, continuationToken.start);
					}
					t = it.next();
				} while (t.type == TokenType.WHITESPACE);
				if (t.type != TokenType.EOL) {
					throw new TemplateParseError(
							"Invalid line continuation", src, continuationToken.start);
				}
				if (!it.hasNext()) {
					throw new TemplateParseError(
							"Invalid line continuation", src, continuationToken.start);
				}
			} else {
				result.add(t);
			}
		}
		return result;
	}

	List<Token> insertStartTokens(List<Token> l) {
		List<Token> result = new ArrayList<Token>();
		result.add(new Token(TokenType.TEMPLATE, 0, 0));
		result.add(new Token(TokenType.LINE, 0, 0));
		for(Token t: l) {
			result.add(t);
			if (t.type == TokenType.EOL) {
				result.add(new Token(TokenType.LINE, t.end, t.end));
			}
		}
		return result;
	}

}
