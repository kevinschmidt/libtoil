package org.libtoil.core;

public class TemplateParseError extends RuntimeException {
	private static final long serialVersionUID = 799759114529840458L;
	String message;
	char[] src;
	int pos;
	
	public TemplateParseError(String message, char[] src, int pos) {
		this.message = message;
		this.src = src;
		this.pos = pos;
	}
	
	public String toString() {
		return "\"" + message + "\" found at " + pos;
	}
	
}
