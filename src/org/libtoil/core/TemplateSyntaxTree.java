package org.libtoil.core;

import java.util.Iterator;

import net.jimblackler.Utils.CollectionAbortedException;
import net.jimblackler.Utils.Collector;
import net.jimblackler.Utils.ResultHandler;
import net.jimblackler.Utils.ThreadedYieldAdapter;

import org.libtoil.core.TemplateTokenizer.Token;
import org.libtoil.core.TemplateTokenizer.TokenType;

public class TemplateSyntaxTree {
	Node root;
	
	public TemplateSyntaxTree(Iterator<Token> it) {
		
	}

	public class Node implements Iterable<Node> {
		Node parent, nextSibling, firstChild, lastChild;
		Token token;
		
		Node(Token t) {
			this.token = t;
		}
		
		void addChild(Node n) {
			n.parent = this;
			if (this.firstChild == null) {
				this.firstChild = n;
			} else {
				this.lastChild.nextSibling = n;
			}
			this.lastChild = n;
		}
		 
		boolean equals(Node n) {
			return this == n;
		}
		
		boolean equalsTree(Node n) {
			throw new UnsupportedOperationException();
		}
		
		public Iterator<Node> iterator() {
			return new ThreadedYieldAdapter<Node>().adapt(new NodeWalker(this)).iterator();
		}
		  
		Node getFirstChild() {
			return firstChild;
		}
		
		Node getNextSibling() {
			return nextSibling;
		}
		
		int childCount () {
			int count = 0;
			Node n = firstChild;
			while (n != null) {
				n = n.nextSibling;
				count++;
			}
			return count;
		}
		
		String getSource() {
			return token.toString();
		}
		
		int getTokenEnd() {
			if (lastChild == null) {
				return token.end;
			} else {
				return lastChild.getTokenEnd();
			}
		}
		
		String getFullSource() {
			return new String(token.getSource(), token.start, getTokenEnd()-token.start);	
		}
		
		TokenType getType() {
			return token.type;
		}

	}
	
	public class NodeWalker implements Collector<Node> {
		Node node;
		
		NodeWalker (Node node) {
			this.node = node;
		}

		public void collect(ResultHandler<Node> handler) throws CollectionAbortedException {
			collect(handler, node);
		}

		public void collect(ResultHandler<Node> handler, Node node) throws CollectionAbortedException {
			handler.handleResult(node);
			Node curChild = node.firstChild;
			while (curChild != null) {
				collect(handler, curChild);
				curChild = curChild.nextSibling;
			}
		}
	}
}
