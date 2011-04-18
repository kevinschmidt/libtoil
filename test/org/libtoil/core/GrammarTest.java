package org.libtoil.core;

import java.io.IOException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.apache.commons.io.IOUtils;
import org.junit.Test;


public class GrammarTest {
    @Test
    public void inline_NamespaceDeclaration() throws IOException, RecognitionException {
        ToilStatementParser parser = createParser("@;namespace=/system/dns@");
        parser.statement();
    }

    @Test
    public void testText() throws IOException, RecognitionException {
    	ToilStatementParser parser = createParser("The swift brown fox jumped over the lazy dog");
        parser.statement();
    }

    @Test
    public void testFail() throws IOException, RecognitionException {
    	ToilStatementParser parser = createParser("@foo@ test");
        parser.statement();
    }

    @Test
    public void inline_BareVariable() throws IOException, RecognitionException {
    	ToilStatementParser parser = createParser("@;string:domain()@");
        parser.statement();
    }

    @Test
    public void inline_TildeVariable() throws IOException, RecognitionException {
    	ToilStatementParser parser = createParser("@;string:~domain()@");
        parser.statement();
    }

    @Test
    public void inline_TildeSlashVariable() throws IOException, RecognitionException {
    	ToilStatementParser parser = createParser("@;string:~/domain()@");
        parser.statement();
    }
    
    @Test
    public void inline_FullPathVariable() throws IOException, RecognitionException {
    	ToilStatementParser parser = createParser("@;string:/system/dns/domain()@");
        parser.statement();
    }
    
    @Test
    public void inline_stringSetVariable() throws IOException, RecognitionException {
    	ToilStatementParser parser = createParser("@;ordered-string-set:nameserver()@");
        parser.statement();
    }
    
    @Test
    public void full_resolv_conf() throws IOException, RecognitionException {
    	String resolv_toil = IOUtils.toString(GrammarTest.class.getResourceAsStream("resolv.conf.toil")); 
    	ToilStatementParser parser = createParser(resolv_toil);
        parser.statement();
    }

    private ToilStatementParser createParser(String testString) throws IOException {
    	CharStream stream = new ANTLRStringStream(testString);
    	ToilStatementLexer lexer = new ToilStatementLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ToilStatementParser parser = new ToilStatementParser(tokens);
        return parser;
    }

}
