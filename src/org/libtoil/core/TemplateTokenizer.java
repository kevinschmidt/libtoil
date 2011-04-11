package org.libtoil.core;

import java.util.Iterator;

public class TemplateTokenizer implements Iterable<TemplateTokenizer.Token> {
	char[] src;

	
	TemplateTokenizer(char[] src) {
		this.src = src;
	}
	
	public Iterator<Token> iterator() {
		return new TemplateTokenizerIterator();
	}
	
	public class TemplateTokenizerIterator implements Iterator<Token> {
		int pos;
		Token nextToken;
		
		public TemplateTokenizerIterator() {
			this.pos = 0;
			this.nextToken = null;
		}

		
		boolean pump() {
			if (nextToken != null) {
				return true;
			}
			while (pos <= src.length) {
				
			}
			return false;
		}



		public boolean hasNext() {
			return this.nextToken != null || pump();
		}



		public Token next() {
			Token temp = nextToken;
			nextToken = null;
			return temp;
		}

		public void remove() {
			throw new UnsupportedOperationException();
			
		}
	}
	




	
	public class Token {
		
	}


}
