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
		System.out.println(output);
		System.out.println(types);
		assertEquals(testOutput, output);
		assertEquals(testTypes, types);
	}
	
	public void testText1() {
		TemplateTokenizer tt = new TemplateTokenizer("The swift brown fox jumped over the lazy dog");
		String testOutput = "The- -swift- -brown- -fox- -jumped- -over- -the- -lazy- -dog";
		String testTypes = "TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL,WS,TL";
		cmp(tt, testOutput, testTypes);
	}

	public void testText2() {
		TemplateTokenizer tt = new TemplateTokenizer("at@@at@ @at@ @@@at@ @ @at@ @at@@ @@@ @at @");
		String testOutput = "at-@@-at-@- -@at@- -@@-@at@- -@- -@at@- -@at@-@- -@@-@- -@-at- -@";
		String testTypes = "TL,AT,TL,AT,WS,CMD,WS,AT,CMD,WS,AT,WS,CMD,WS,CMD,AT,WS,AT,AT,WS,AT,TL,WS,AT";
		cmp(tt, testOutput, testTypes);
	}

	public void testText3() {
		TemplateTokenizer tt = new TemplateTokenizer("this is\n a multi\nline \ntest");
		String testOutput = "this- -is-\n- -a- -multi-\n-line- -\n-test";
		String testTypes = "TL,WS,TL,EOL,WS,TL,WS,TL,EOL,TL,WS,EOL,TL";
		cmp(tt, testOutput, testTypes);
	}
	
	public void testText4() {
		TemplateTokenizer tt = new TemplateTokenizer("@cmd@ text\n@#comment\n\n@#c@#m#m@@e@#nt\n@#eof");
		String testOutput = "@cmd@- -text-\n-@#comment-\n-\n-@#c@#m#m@@e@#nt-\n-@#eof";
		String testTypes = "CMD,WS,TL,EOL,COMMENT,EOL,EOL,COMMENT,EOL,COMMENT";
		cmp(tt, testOutput, testTypes);
	}
}
