package org.libtoil.core;

import java.util.Iterator;

import net.jimblackler.Utils.CollectionAbortedException;
import net.jimblackler.Utils.Collector;
import net.jimblackler.Utils.ResultHandler;
import net.jimblackler.Utils.ThreadedYieldAdapter;

public class TemplateTokenizer implements Iterable<TemplateTokenizer.Token> {
	char[] src;

	TemplateTokenizer(char[] src) {
		this.src = src;
	}
	
	TemplateTokenizer(String srcString) {
		this.src = srcString.toCharArray();
	}
	
	public Iterator<Token> iterator() {
		Iterator<Token> it = new TemplateTokenizerIterator();
		Collector<Token> coll = new LineContRemovalCollector(it);
		it = new ThreadedYieldAdapter<Token>().adapt(coll).iterator();
		return it;
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
	
	public class LineContRemovalCollector implements Collector<Token> { 
		Iterator<Token> it;

		public LineContRemovalCollector(Iterator<Token> it) {
			this.it = it;
		}

		public void collect(ResultHandler<Token> handler) throws CollectionAbortedException {
			while (it.hasNext()) {
				Token t = it.next();
				if (t.type == "LINECONTINUATION") {
					Token continuationToken = t;
					do {
						if (!it.hasNext()) {
							throw new TemplateParseError("Invalid line continuation", src, continuationToken.start);
						}
						t = it.next();
					} while (t.type == "WHITESPACE");
					if (t.type != "EOL") {
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
		public String type;
		public int start, end;
		
		public Token(String type, int start, int end) {
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
