package org.libtoil.core;
import junit.framework.TestCase;


public class TemplateTokenizerIteratorTest extends TestCase {
	public String shorten(String s) {
		if (s == "TEXTLITERAL") return "TL";
		if (s == "WHITESPACE") return "WS";
		if (s == "LITERALAT") return "AT";
		if (s == "COMMAND") return "CMD";
		if (s == "EOL") return "EOL";
		return s;
	}

	public void cmp(TemplateTokenizer tt, String testOutput, String testTypes) {
		String output = "";
		String types = "";
		for(TemplateTokenizer.Token t : tt) {
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
			for(TemplateTokenizer.Token t : tt) {
	
			}
		} catch (TemplateParseError e) {
//			System.out.println(e);
			assertEquals(pos, e.pos);
		}
	}
	
	public void testText1() {
		TemplateTokenizer tt = new TemplateTokenizer("The swift brown fox jumped over the lazy dog");
		String testOutput = "The- -swift- -brown- -fox- -jumped- -over- -the- -lazy- -dog";
		String testTypes = "TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL";
		cmp(tt, testOutput, testTypes);
	}

	public void testAt1() {
		TemplateTokenizer tt = new TemplateTokenizer("at@@at@ @at @ @@@at@ @ @ at@ @at@@ @@@ @at @");
		String testOutput = "at-@@-at-@- -@-at- -@- -@@-@at@- -@- -@- -at-@- -@at@-@- -@@-@- -@-at- -@";
		String testTypes = "TL,AT,TL,AT,WS,AT,TL,WS,AT,WS,AT,CMD,WS,AT,WS,AT,WS,TL,AT,WS,CMD,AT,WS,AT,AT,WS,AT,TL,WS,AT";
		cmp(tt, testOutput, testTypes);
	}

	public void testLines1() {
		TemplateTokenizer tt = new TemplateTokenizer("this is\n a multi\nline \ntest");
		String testOutput = "this- -is-\n- -a- -multi-\n-line- -\n-test";
		String testTypes = "TL,WS,TL,EOL,WS,TL,WS,TL,EOL,TL,WS,EOL,TL";
		cmp(tt, testOutput, testTypes);
	}
	
	public void testComments1() {
		TemplateTokenizer tt = new TemplateTokenizer("@cmd@ text\n@#comment\n\n@#c@#m#m@@e@#nt\n@#eof");
		String testOutput = "@cmd@- -text-\n-@#comment-\n-\n-@#c@#m#m@@e@#nt-\n-@#eof";
		String testTypes = "CMD,WS,TL,EOL,COMMENT,EOL,EOL,COMMENT,EOL,COMMENT";
		cmp(tt, testOutput, testTypes);
	}
	
	public void testLineConts1() {
		TemplateTokenizer tt = new TemplateTokenizer("This should @\\ \nall be@\\\n on o@\\\nne li@\\ \nne");
		String testOutput = "This- -should- -all- -be- -on- -o-ne- -li-ne";
		String testTypes = "TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL,TL,WS,TL,TL";
		cmp(tt, testOutput, testTypes);
	}
	
	public void testLineContError1() {
		TemplateTokenizer tt = new TemplateTokenizer("Line continuation in the @\\ middle of a line.");
		cmpError(tt, 25);
	}
	
	public void testLineContError2() {
		TemplateTokenizer tt = new TemplateTokenizer("Line continuation at the end of a file. @\\   ");
		cmpError(tt, 40);
	}

	public void testLineContError3() {
		TemplateTokenizer tt = new TemplateTokenizer("Line continuation at the end of a file. @\\");
		cmpError(tt, 40);
	}
}