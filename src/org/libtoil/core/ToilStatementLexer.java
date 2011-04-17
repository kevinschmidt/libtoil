// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g 2011-04-17 11:36:07

  package org.libtoil.core;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ToilStatementLexer extends Lexer {
    public static final int EOF=-1;
    public static final int AT=4;
    public static final int OPENP=5;
    public static final int SEMI=6;
    public static final int CLOSEP=7;
    public static final int OPENC=8;
    public static final int CLOSEC=9;
    public static final int EOL=10;
    public static final int WS=11;
    public static final int COLON=12;
    public static final int EQUALS=13;
    public static final int DOLLAR=14;
    public static final int ID=15;
    public static final int DOT=16;
    public static final int QUOTED=17;
    public static final int HASH=18;
    public static final int COMMENT=19;

    // delegates
    // delegators

    public ToilStatementLexer() {;} 
    public ToilStatementLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ToilStatementLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g"; }

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:81:3: ( '.' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:81:5: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "OPENC"
    public final void mOPENC() throws RecognitionException {
        try {
            int _type = OPENC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:85:3: ( '{' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:85:5: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPENC"

    // $ANTLR start "CLOSEC"
    public final void mCLOSEC() throws RecognitionException {
        try {
            int _type = CLOSEC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:89:3: ( '}' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:89:5: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSEC"

    // $ANTLR start "OPENP"
    public final void mOPENP() throws RecognitionException {
        try {
            int _type = OPENP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:93:3: ( '(' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:93:5: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPENP"

    // $ANTLR start "CLOSEP"
    public final void mCLOSEP() throws RecognitionException {
        try {
            int _type = CLOSEP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:97:3: ( ')' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:97:5: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSEP"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:101:3: ( '=' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:101:5: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:105:3: ( ':' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:105:5: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:109:3: ( '$' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:109:5: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "HASH"
    public final void mHASH() throws RecognitionException {
        try {
            int _type = HASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:113:3: ( '#' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:113:5: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HASH"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:117:3: ( ';' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:117:5: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "AT"
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:121:3: ( '@' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:121:5: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT"

    // $ANTLR start "QUOTED"
    public final void mQUOTED() throws RecognitionException {
        try {
            int _type = QUOTED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:125:3: ( '\"' (~ '\"' )* '\"' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:125:5: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:125:9: (~ '\"' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:125:9: ~ '\"'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTED"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:129:3: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '-' )* )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:129:5: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '-' )*
            {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:129:5: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '-' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-'||(LA2_0>='/' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='/' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "EOL"
    public final void mEOL() throws RecognitionException {
        try {
            int _type = EOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:133:3: ( ( '\\r' )? '\\n' )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:133:5: ( '\\r' )? '\\n'
            {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:133:5: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:133:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EOL"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:137:3: ( ( ' ' | '\\t' )+ )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:137:5: ( ' ' | '\\t' )+
            {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:137:5: ( ' ' | '\\t' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:141:5: ( '#' (~ ( '\\r' | '\\n' ) )* )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:141:7: '#' (~ ( '\\r' | '\\n' ) )*
            {
            match('#'); 
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:141:11: (~ ( '\\r' | '\\n' ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:141:11: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    public void mTokens() throws RecognitionException {
        // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:8: ( DOT | OPENC | CLOSEC | OPENP | CLOSEP | EQUALS | COLON | DOLLAR | HASH | SEMI | AT | QUOTED | ID | EOL | WS | COMMENT )
        int alt6=16;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:10: DOT
                {
                mDOT(); 

                }
                break;
            case 2 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:14: OPENC
                {
                mOPENC(); 

                }
                break;
            case 3 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:20: CLOSEC
                {
                mCLOSEC(); 

                }
                break;
            case 4 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:27: OPENP
                {
                mOPENP(); 

                }
                break;
            case 5 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:33: CLOSEP
                {
                mCLOSEP(); 

                }
                break;
            case 6 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:40: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 7 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:47: COLON
                {
                mCOLON(); 

                }
                break;
            case 8 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:53: DOLLAR
                {
                mDOLLAR(); 

                }
                break;
            case 9 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:60: HASH
                {
                mHASH(); 

                }
                break;
            case 10 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:65: SEMI
                {
                mSEMI(); 

                }
                break;
            case 11 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:70: AT
                {
                mAT(); 

                }
                break;
            case 12 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:73: QUOTED
                {
                mQUOTED(); 

                }
                break;
            case 13 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:80: ID
                {
                mID(); 

                }
                break;
            case 14 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:83: EOL
                {
                mEOL(); 

                }
                break;
            case 15 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:87: WS
                {
                mWS(); 

                }
                break;
            case 16 :
                // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:1:90: COMMENT
                {
                mCOMMENT(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\15\10\uffff\1\20\10\uffff";
    static final String DFA6_eofS =
        "\22\uffff";
    static final String DFA6_minS =
        "\1\11\10\uffff\1\0\10\uffff";
    static final String DFA6_maxS =
        "\1\175\10\uffff\1\uffff\10\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\11\1\20";
    static final String DFA6_specialS =
        "\11\uffff\1\0\10\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\17\1\16\2\uffff\1\16\22\uffff\1\17\1\uffff\1\14\1\11\1\10"+
            "\3\uffff\1\4\1\5\4\uffff\1\1\13\uffff\1\7\1\12\1\uffff\1\6\2"+
            "\uffff\1\13\72\uffff\1\2\1\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\21\1\uffff\2\21\1\uffff\ufff2\21",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( DOT | OPENC | CLOSEC | OPENP | CLOSEP | EQUALS | COLON | DOLLAR | HASH | SEMI | AT | QUOTED | ID | EOL | WS | COMMENT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_9 = input.LA(1);

                        s = -1;
                        if ( ((LA6_9>='\u0000' && LA6_9<='\t')||(LA6_9>='\u000B' && LA6_9<='\f')||(LA6_9>='\u000E' && LA6_9<='\uFFFF')) ) {s = 17;}

                        else s = 16;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}