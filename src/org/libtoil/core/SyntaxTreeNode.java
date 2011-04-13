package org.libtoil.core;

import java.util.Iterator;


import net.jimblackler.Utils.CollectionAbortedException;
import net.jimblackler.Utils.Collector;
import net.jimblackler.Utils.ResultHandler;
import net.jimblackler.Utils.ThreadedYieldAdapter;

import org.libtoil.core.TemplateTokenizer.Token;
import org.libtoil.core.TemplateTokenizer.TokenType;

public class SyntaxTreeNode implements Iterable<SyntaxTreeNode> {
	SyntaxTreeNode parent, nextSibling, firstChild, lastChild;
	Token token;
	
	SyntaxTreeNode(Token t) {
		this.token = t;
	}
	
	void addChild(SyntaxTreeNode n) {
		n.parent = this;
		if (this.firstChild == null) {
			this.firstChild = n;
		} else {
			this.lastChild.nextSibling = n;
		}
		this.lastChild = n;
	}
	 
	boolean equals(SyntaxTreeNode n) {
		return this == n;
	}
	
	boolean equalsTree(SyntaxTreeNode n) {
		throw new UnsupportedOperationException();
	}
	  
	SyntaxTreeNode getFirstChild() {
		return firstChild;
	}
	
	SyntaxTreeNode getNextSibling() {
		return nextSibling;
	}
	
	int childCount () {
		int count = 0;
		SyntaxTreeNode n = firstChild;
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

	public Iterable<Token> getTokens() {
        return new ThreadedYieldAdapter<Token>().adapt(new Collector<Token>() {
            public void collect(ResultHandler<Token> resultHandler) throws
                    CollectionAbortedException {
            	for(SyntaxTreeNode node: SyntaxTreeNode.this) {
            		resultHandler.handleResult(node.token);
            	}
            }
        });
	}
	
    public Iterator<SyntaxTreeNode> iterator() {
        return new ThreadedYieldAdapter<SyntaxTreeNode>().adapt(new Collector<SyntaxTreeNode>() {
            public void collect(ResultHandler<SyntaxTreeNode> resultHandler) throws
                    CollectionAbortedException {
            	traverseDepthFirst(SyntaxTreeNode.this, resultHandler);
            }
        }).iterator();
    }
    
	public void traverseDepthFirst(SyntaxTreeNode node, ResultHandler<SyntaxTreeNode> handler) throws CollectionAbortedException {
		handler.handleResult(node);
		SyntaxTreeNode curChild = node.firstChild;
		while (curChild != null) {
			traverseDepthFirst(curChild, handler);
			curChild = curChild.nextSibling;
		}
	}


}
