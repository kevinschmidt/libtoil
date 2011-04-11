package org.libtoil.core;

import java.util.Iterator;

public class TemplateTokenizer implements Iterable<TemplateTokenizer.Token> {
	char[] src;

	TemplateTokenizer(char[] src) {
		this.src = src;
	}
	
	TemplateTokenizer(String srcString) {
		this.src = srcString.toCharArray();
	}
	
	public Iterator<Token> iterator() {
		return new LineContRemovalIterator(new TemplateTokenizerIterator());
	}
	
	public class TemplateTokenizerIterator implements Iterator<Token> {
		int pos;
		Token nextToken;
		
		public TemplateTokenizerIterator() {
			this.pos = 0;
			this.nextToken = null;
		}

		boolean fetch() {
			if (nextToken != null) {
				return true;
			}
			if (!(pos < src.length)) {
				return false;
			}
			if (src[pos] == '\n') {
				nextToken = new Token("EOL", pos, pos+1);
				pos = pos+1;
				return true;
			} else if (src[pos] == '@') {
				int cur = pos+1;
				if (cur < src.length && src[cur] == '#') { // We are in a comment
					while (cur < src.length && src[cur] != '\n') {
						cur++;
					}
					nextToken = new Token("COMMENT", pos, cur);
					pos = cur;
					return true;
				}
				if (cur < src.length && src[cur] == '\\') { // line continuation
					nextToken = new Token("LINECONTINUATION", pos, ++cur);
					pos = cur;
					return true;
				}
				while (cur < src.length && src[cur] != '@' && !Character.isWhitespace(src[cur])) {
					cur++;
				}
				if (cur == src.length || src[cur] != '@') { // loop terminated before finding @
					nextToken = new Token("LITERALAT", pos, ++pos);

					return true;
				} else if (cur - pos == 1) { // found "@@"
					nextToken = new Token("LITERALAT", pos, ++cur);
					pos = cur;
					return true;
				} else {
					nextToken = new Token("COMMAND", pos, ++cur);
					pos = cur;
					return true;
				}
			} else if (Character.isWhitespace(src[pos])) {
				int cur = pos+1;
				while (cur < src.length && Character.isWhitespace(src[cur]) && src[cur] != '\n') {
					cur++;
				}
				nextToken = new Token("WHITESPACE", pos, cur);
				pos = cur;
				return true;
			} else {
				int cur = pos+1;
				while (cur < src.length && src[cur] != '@' && !Character.isWhitespace(src[cur])) {
					cur++;
				}
				nextToken = new Token("TEXTLITERAL", pos, cur);
				pos = cur;
				return true;
			}
		}
		
		public boolean hasNext() {
			return nextToken != null || fetch();
		}

		public Token next() {
			fetch();
			Token temp = nextToken;
			nextToken = null;
			return temp;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public class LineContRemovalIterator implements Iterator<Token> { 
		Token nextToken;
		Iterator<Token> it;

		public LineContRemovalIterator(Iterator<Token> it) {
			this.nextToken = null;
			this.it = it;
		}
		
		public boolean hasNext() {
			return nextToken != null || fetch();
		}
		
		public Token next() {
			fetch();
			Token temp = nextToken;
			nextToken = null;
			return temp;
		}
		
		public boolean fetch() {
			if (nextToken != null) {
				return true;
			}
			if (!it.hasNext()) {
				return false;
			}
			nextToken = it.next();
			if (nextToken.type == "LINECONTINUATION") {
				do {
					nextToken = it.next();
				} while (nextToken.type == "WHITESPACE");
				assert nextToken.type == "EOL";
				nextToken = it.next();
			}
			return true;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
	
	
	public class Token {
		public String type;
		public int start, end;
		
		public Token(String type, int start, int end) {
			this.type = type;
			this.start = start;
			this.end = end;
		}
		
		public String toString() {
			return new String(src, start, end-start);
		}
	}


}
