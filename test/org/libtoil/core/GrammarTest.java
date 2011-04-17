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
    public void header_Namespace() throws IOException, RecognitionException {
        ToilStatementParser parser = createParser("@;namespace=/system/dns@");
        parser.statement();
    }
    
    @Test
    public void header_BasicVariable_ShortNamespace() throws IOException, RecognitionException {
        ToilStatementParser parser = createParser("@;string:domain()@");
        parser.statement();
    }
    
    @Test
    public void header_BasicVariable_FullNamespace() throws IOException, RecognitionException {
        ToilStatementParser parser = createParser("@;string:/system/dns/domain()@");
        parser.statement();
    }
    
    @Test
    public void header_LeafSetVariable_ShortNamespace() throws IOException, RecognitionException {
        ToilStatementParser parser = createParser("@;string-set:nameserver()@");
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
