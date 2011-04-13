package org.libtoil.core;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail; 
import org.libtoil.core.TemplateTokenizer.TokenType;


public class TemplateTokenizerIteratorTest {
	public String shorten(TokenType type) {
		if (type == TokenType.TEXTLITERAL) return "TL";
		if (type == TokenType.WHITESPACE) return "WS";
		if (type == TokenType.LITERALAT) return "AT";
		if (type == TokenType.COMMAND) return "CMD";
		if (type == TokenType.EOL) return "EOL";
		if (type == TokenType.TEMPLATE) return "TPL";
		if (type == TokenType.LINE) return "NL";
		return type.toString();
	}

	public void cmp(TemplateTokenizer tt, String testOutput, String testTypes) {
		String output = "";
		String types = "";
		for(TemplateTokenizer.Token t : tt.parseTree().getTokens()) {
			output += (output.isEmpty() ? "" : "-") + t;
			types += (types.isEmpty() ? "" : ",") + shorten(t.type);
		}
//		System.out.println(output);
//		System.out.println(types);
		assertEquals(testOutput, output);
		assertEquals(testTypes, types);
	}
	
	public void cmpError(TemplateTokenizer tt, int pos) {
		try {
			for(@SuppressWarnings("unused") TemplateTokenizer.Token t : tt.parseTree().getTokens());
			fail("expected TemplateParseError not thrown");
		} catch (TemplateParseError e) {
//			System.out.println(e);
			assertEquals(pos, e.pos);
		}
	}
	
	@Test
	public void testText1() {
		TemplateTokenizer tt = new TemplateTokenizer("The swift brown fox jumped over the lazy dog");
		String testOutput = "The- -swift- -brown- -fox- -jumped- -over- -the- -lazy- -dog";
		String testTypes = "TPL,NL,TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL";
		cmp(tt, testOutput, testTypes);
	}

	@Test
	public void testAt1() {
		TemplateTokenizer tt = new TemplateTokenizer("at@@at@ @at @ @@@at@ @ @ at@ @at@@ @@@ @at @");
		String testOutput = "at-@@-at-@- -@-at- -@- -@@-@at@- -@- -@- -at-@- -@at@-@- -@@-@- -@-at- -@";
		String testTypes = "TPL,NL,TL,AT,TL,AT,WS,AT,TL,WS,AT,WS,AT,CMD,WS,AT,WS,AT,WS,TL,AT,WS,CMD,AT,WS,AT,AT,WS,AT,TL,WS,AT";
		cmp(tt, testOutput, testTypes);
	}

	@Test
	public void testLines1() {
		TemplateTokenizer tt = new TemplateTokenizer("this is\n a multi\nline \ntest");
		String testOutput = "this- -is-\n-- -a- -multi-\n--line- -\n--test";
		String testTypes = "TPL,NL,TL,WS,TL,EOL,NL,WS,TL,WS,TL,EOL,NL,TL,WS,EOL,NL,TL";
		cmp(tt, testOutput, testTypes);
	}
	
	@Test
	public void testComments1() {
		TemplateTokenizer tt = new TemplateTokenizer("@cmd@ text\n@#comment\n\n@#c@#m#m@@e@#nt\n@#eof");
		String testOutput = "@cmd@- -text-\n--@#comment-\n--\n--@#c@#m#m@@e@#nt-\n--@#eof";
		String testTypes = "TPL,NL,CMD,WS,TL,EOL,NL,COMMENT,EOL,NL,EOL,NL,COMMENT,EOL,NL,COMMENT";
		cmp(tt, testOutput, testTypes);
	}
	
	@Test
	public void testLineConts1() {
		TemplateTokenizer tt = new TemplateTokenizer("This should @\\ \nall be@\\\n on o@\\\nne li@\\ \nne");
		String testOutput = "This- -should- -all- -be- -on- -o-ne- -li-ne";
		String testTypes = "TPL,NL,TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL,TL,WS,TL,TL";
		cmp(tt, testOutput, testTypes);
	}
	
	@Test
	public void testLineContError1() {
		TemplateTokenizer tt = new TemplateTokenizer("Line continuation in the @\\ middle of a line.");
		cmpError(tt, 25);
	}
	
	@Test
	public void testLineContError2() {
		TemplateTokenizer tt = new TemplateTokenizer("Line continuation at the end of a file. @\\   ");
		cmpError(tt, 40);
	}

	@Test
	public void testLineContError3() {
		TemplateTokenizer tt = new TemplateTokenizer("Line continuation at the end of a file. @\\");
		cmpError(tt, 40);
	}
}