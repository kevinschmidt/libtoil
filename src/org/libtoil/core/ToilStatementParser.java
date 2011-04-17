// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g 2011-04-17 11:36:07

  package org.libtoil.core;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ToilStatementParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AT", "OPENP", "SEMI", "CLOSEP", "OPENC", "CLOSEC", "EOL", "WS", "COLON", "EQUALS", "DOLLAR", "ID", "DOT", "QUOTED", "HASH", "COMMENT"
    };
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


        public ToilStatementParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ToilStatementParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ToilStatementParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g"; }



    // $ANTLR start "statement"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:15:1: statement : ( variable | control | declarations );
    public final void statement() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:16:5: ( variable | control | declarations )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==AT) ) {
                switch ( input.LA(2) ) {
                case DOLLAR:
                    {
                    alt1=2;
                    }
                    break;
                case SEMI:
                    {
                    alt1=3;
                    }
                    break;
                case ID:
                case DOT:
                    {
                    alt1=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:16:7: variable
                    {
                    pushFollow(FOLLOW_variable_in_statement42);
                    variable();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:16:18: control
                    {
                    pushFollow(FOLLOW_control_in_statement46);
                    control();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:16:28: declarations
                    {
                    pushFollow(FOLLOW_declarations_in_statement50);
                    declarations();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "statement"


    // $ANTLR start "variable"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:24:1: variable : AT var_name ( OPENP ( ( SEMI )* ( inline_option ) )* ( SEMI )* CLOSEP )? AT ;
    public final void variable() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:25:3: ( AT var_name ( OPENP ( ( SEMI )* ( inline_option ) )* ( SEMI )* CLOSEP )? AT )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:25:5: AT var_name ( OPENP ( ( SEMI )* ( inline_option ) )* ( SEMI )* CLOSEP )? AT
            {
            match(input,AT,FOLLOW_AT_in_variable71); 
            pushFollow(FOLLOW_var_name_in_variable73);
            var_name();

            state._fsp--;

            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:25:17: ( OPENP ( ( SEMI )* ( inline_option ) )* ( SEMI )* CLOSEP )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==OPENP) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:25:18: OPENP ( ( SEMI )* ( inline_option ) )* ( SEMI )* CLOSEP
                    {
                    match(input,OPENP,FOLLOW_OPENP_in_variable76); 
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:25:24: ( ( SEMI )* ( inline_option ) )*
                    loop3:
                    do {
                        int alt3=2;
                        alt3 = dfa3.predict(input);
                        switch (alt3) {
                    	case 1 :
                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:25:25: ( SEMI )* ( inline_option )
                    	    {
                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:25:25: ( SEMI )*
                    	    loop2:
                    	    do {
                    	        int alt2=2;
                    	        int LA2_0 = input.LA(1);

                    	        if ( (LA2_0==SEMI) ) {
                    	            alt2=1;
                    	        }


                    	        switch (alt2) {
                    	    	case 1 :
                    	    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:25:25: SEMI
                    	    	    {
                    	    	    match(input,SEMI,FOLLOW_SEMI_in_variable79); 

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop2;
                    	        }
                    	    } while (true);

                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:25:31: ( inline_option )
                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:25:32: inline_option
                    	    {
                    	    pushFollow(FOLLOW_inline_option_in_variable83);
                    	    inline_option();

                    	    state._fsp--;


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:25:49: ( SEMI )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==SEMI) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:25:49: SEMI
                    	    {
                    	    match(input,SEMI,FOLLOW_SEMI_in_variable88); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match(input,CLOSEP,FOLLOW_CLOSEP_in_variable91); 

                    }
                    break;

            }

            match(input,AT,FOLLOW_AT_in_variable95); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "variable"


    // $ANTLR start "declarations"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:28:1: declarations : AT SEMI ( inline_declarations | ( ( OPENC )+ header_declarations ( CLOSEC )+ ) ) AT ;
    public final void declarations() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:29:3: ( AT SEMI ( inline_declarations | ( ( OPENC )+ header_declarations ( CLOSEC )+ ) ) AT )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:29:5: AT SEMI ( inline_declarations | ( ( OPENC )+ header_declarations ( CLOSEC )+ ) ) AT
            {
            match(input,AT,FOLLOW_AT_in_declarations110); 
            match(input,SEMI,FOLLOW_SEMI_in_declarations112); 
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:29:13: ( inline_declarations | ( ( OPENC )+ header_declarations ( CLOSEC )+ ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==AT||(LA8_0>=SEMI && LA8_0<=CLOSEP)||LA8_0==ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==OPENC) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:29:14: inline_declarations
                    {
                    pushFollow(FOLLOW_inline_declarations_in_declarations115);
                    inline_declarations();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:29:36: ( ( OPENC )+ header_declarations ( CLOSEC )+ )
                    {
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:29:36: ( ( OPENC )+ header_declarations ( CLOSEC )+ )
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:29:38: ( OPENC )+ header_declarations ( CLOSEC )+
                    {
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:29:38: ( OPENC )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==OPENC) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:29:38: OPENC
                    	    {
                    	    match(input,OPENC,FOLLOW_OPENC_in_declarations121); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    pushFollow(FOLLOW_header_declarations_in_declarations124);
                    header_declarations();

                    state._fsp--;

                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:29:65: ( CLOSEC )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==CLOSEC) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:29:65: CLOSEC
                    	    {
                    	    match(input,CLOSEC,FOLLOW_CLOSEC_in_declarations126); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,AT,FOLLOW_AT_in_declarations132); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "declarations"


    // $ANTLR start "header_declarations"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:32:1: header_declarations : ( ( SEMI | EOL | WS )* ( header_variable | header_option ) )* ( SEMI | EOL | WS )* ;
    public final void header_declarations() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:33:3: ( ( ( SEMI | EOL | WS )* ( header_variable | header_option ) )* ( SEMI | EOL | WS )* )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:33:5: ( ( SEMI | EOL | WS )* ( header_variable | header_option ) )* ( SEMI | EOL | WS )*
            {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:33:5: ( ( SEMI | EOL | WS )* ( header_variable | header_option ) )*
            loop11:
            do {
                int alt11=2;
                alt11 = dfa11.predict(input);
                switch (alt11) {
            	case 1 :
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:33:6: ( SEMI | EOL | WS )* ( header_variable | header_option )
            	    {
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:33:6: ( SEMI | EOL | WS )*
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==SEMI||(LA9_0>=EOL && LA9_0<=WS)) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:
            	    	    {
            	    	    if ( input.LA(1)==SEMI||(input.LA(1)>=EOL && input.LA(1)<=WS) ) {
            	    	        input.consume();
            	    	        state.errorRecovery=false;
            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        throw mse;
            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop9;
            	        }
            	    } while (true);

            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:33:25: ( header_variable | header_option )
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==ID) ) {
            	        switch ( input.LA(2) ) {
            	        case WS:
            	            {
            	            int LA10_2 = input.LA(3);

            	            if ( ((LA10_2>=WS && LA10_2<=COLON)||(LA10_2>=ID && LA10_2<=DOT)) ) {
            	                alt10=1;
            	            }
            	            else if ( (LA10_2==EQUALS) ) {
            	                alt10=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 10, 2, input);

            	                throw nvae;
            	            }
            	            }
            	            break;
            	        case COLON:
            	            {
            	            alt10=1;
            	            }
            	            break;
            	        case EQUALS:
            	            {
            	            alt10=2;
            	            }
            	            break;
            	        default:
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 10, 1, input);

            	            throw nvae;
            	        }

            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:33:26: header_variable
            	            {
            	            pushFollow(FOLLOW_header_variable_in_header_declarations160);
            	            header_variable();

            	            state._fsp--;


            	            }
            	            break;
            	        case 2 :
            	            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:33:44: header_option
            	            {
            	            pushFollow(FOLLOW_header_option_in_header_declarations164);
            	            header_option();

            	            state._fsp--;


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:33:61: ( SEMI | EOL | WS )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==SEMI||(LA12_0>=EOL && LA12_0<=WS)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:
            	    {
            	    if ( input.LA(1)==SEMI||(input.LA(1)>=EOL && input.LA(1)<=WS) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "header_declarations"


    // $ANTLR start "header_variable"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:36:1: header_variable : var_type ( COLON | WS )+ var_name ( ( EOL | WS )* OPENP header_declarations CLOSEP )? ;
    public final void header_variable() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:37:3: ( var_type ( COLON | WS )+ var_name ( ( EOL | WS )* OPENP header_declarations CLOSEP )? )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:37:5: var_type ( COLON | WS )+ var_name ( ( EOL | WS )* OPENP header_declarations CLOSEP )?
            {
            pushFollow(FOLLOW_var_type_in_header_variable193);
            var_type();

            state._fsp--;

            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:37:14: ( COLON | WS )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=WS && LA13_0<=COLON)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:
            	    {
            	    if ( (input.LA(1)>=WS && input.LA(1)<=COLON) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            pushFollow(FOLLOW_var_name_in_header_variable204);
            var_name();

            state._fsp--;

            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:37:37: ( ( EOL | WS )* OPENP header_declarations CLOSEP )?
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:37:39: ( EOL | WS )* OPENP header_declarations CLOSEP
                    {
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:37:39: ( EOL | WS )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=EOL && LA14_0<=WS)) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:
                    	    {
                    	    if ( (input.LA(1)>=EOL && input.LA(1)<=WS) ) {
                    	        input.consume();
                    	        state.errorRecovery=false;
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    match(input,OPENP,FOLLOW_OPENP_in_header_variable217); 
                    pushFollow(FOLLOW_header_declarations_in_header_variable219);
                    header_declarations();

                    state._fsp--;

                    match(input,CLOSEP,FOLLOW_CLOSEP_in_header_variable221); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "header_variable"


    // $ANTLR start "header_option"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:40:1: header_option : option_name ( WS )? EQUALS ( WS )? option_value ;
    public final void header_option() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:41:3: ( option_name ( WS )? EQUALS ( WS )? option_value )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:41:5: option_name ( WS )? EQUALS ( WS )? option_value
            {
            pushFollow(FOLLOW_option_name_in_header_option236);
            option_name();

            state._fsp--;

            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:41:17: ( WS )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==WS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:41:17: WS
                    {
                    match(input,WS,FOLLOW_WS_in_header_option238); 

                    }
                    break;

            }

            match(input,EQUALS,FOLLOW_EQUALS_in_header_option241); 
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:41:28: ( WS )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==WS) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:41:28: WS
                    {
                    match(input,WS,FOLLOW_WS_in_header_option243); 

                    }
                    break;

            }

            pushFollow(FOLLOW_option_value_in_header_option246);
            option_value();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "header_option"


    // $ANTLR start "inline_declarations"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:44:1: inline_declarations : ( ( SEMI )* ( inline_variable | inline_option ) )* ( SEMI )* ;
    public final void inline_declarations() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:45:3: ( ( ( SEMI )* ( inline_variable | inline_option ) )* ( SEMI )* )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:45:5: ( ( SEMI )* ( inline_variable | inline_option ) )* ( SEMI )*
            {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:45:5: ( ( SEMI )* ( inline_variable | inline_option ) )*
            loop20:
            do {
                int alt20=2;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:45:6: ( SEMI )* ( inline_variable | inline_option )
            	    {
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:45:6: ( SEMI )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==SEMI) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:45:6: SEMI
            	    	    {
            	    	    match(input,SEMI,FOLLOW_SEMI_in_inline_declarations260); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop18;
            	        }
            	    } while (true);

            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:45:12: ( inline_variable | inline_option )
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==ID) ) {
            	        int LA19_1 = input.LA(2);

            	        if ( (LA19_1==COLON) ) {
            	            alt19=1;
            	        }
            	        else if ( (LA19_1==EQUALS) ) {
            	            alt19=2;
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 19, 1, input);

            	            throw nvae;
            	        }
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:45:13: inline_variable
            	            {
            	            pushFollow(FOLLOW_inline_variable_in_inline_declarations264);
            	            inline_variable();

            	            state._fsp--;


            	            }
            	            break;
            	        case 2 :
            	            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:45:31: inline_option
            	            {
            	            pushFollow(FOLLOW_inline_option_in_inline_declarations268);
            	            inline_option();

            	            state._fsp--;


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:45:48: ( SEMI )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==SEMI) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:45:48: SEMI
            	    {
            	    match(input,SEMI,FOLLOW_SEMI_in_inline_declarations273); 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "inline_declarations"


    // $ANTLR start "inline_variable"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:48:1: inline_variable : var_type COLON var_name ( OPENP inline_declarations CLOSEP )? ;
    public final void inline_variable() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:49:3: ( var_type COLON var_name ( OPENP inline_declarations CLOSEP )? )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:49:5: var_type COLON var_name ( OPENP inline_declarations CLOSEP )?
            {
            pushFollow(FOLLOW_var_type_in_inline_variable287);
            var_type();

            state._fsp--;

            match(input,COLON,FOLLOW_COLON_in_inline_variable289); 
            pushFollow(FOLLOW_var_name_in_inline_variable291);
            var_name();

            state._fsp--;

            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:49:29: ( OPENP inline_declarations CLOSEP )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==OPENP) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:49:30: OPENP inline_declarations CLOSEP
                    {
                    match(input,OPENP,FOLLOW_OPENP_in_inline_variable294); 
                    pushFollow(FOLLOW_inline_declarations_in_inline_variable296);
                    inline_declarations();

                    state._fsp--;

                    match(input,CLOSEP,FOLLOW_CLOSEP_in_inline_variable298); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "inline_variable"


    // $ANTLR start "inline_option"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:52:1: inline_option : option_name EQUALS option_value ;
    public final void inline_option() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:53:3: ( option_name EQUALS option_value )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:53:5: option_name EQUALS option_value
            {
            pushFollow(FOLLOW_option_name_in_inline_option313);
            option_name();

            state._fsp--;

            match(input,EQUALS,FOLLOW_EQUALS_in_inline_option315); 
            pushFollow(FOLLOW_option_value_in_inline_option317);
            option_value();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "inline_option"


    // $ANTLR start "control"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:56:1: control : AT DOLLAR control_id ( COLON var_name )? ( OPENP ( ( SEMI )* ( inline_option ) )* ( SEMI )* CLOSEP )? AT ;
    public final void control() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:3: ( AT DOLLAR control_id ( COLON var_name )? ( OPENP ( ( SEMI )* ( inline_option ) )* ( SEMI )* CLOSEP )? AT )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:5: AT DOLLAR control_id ( COLON var_name )? ( OPENP ( ( SEMI )* ( inline_option ) )* ( SEMI )* CLOSEP )? AT
            {
            match(input,AT,FOLLOW_AT_in_control331); 
            match(input,DOLLAR,FOLLOW_DOLLAR_in_control333); 
            pushFollow(FOLLOW_control_id_in_control335);
            control_id();

            state._fsp--;

            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:26: ( COLON var_name )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==COLON) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:27: COLON var_name
                    {
                    match(input,COLON,FOLLOW_COLON_in_control338); 
                    pushFollow(FOLLOW_var_name_in_control340);
                    var_name();

                    state._fsp--;


                    }
                    break;

            }

            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:44: ( OPENP ( ( SEMI )* ( inline_option ) )* ( SEMI )* CLOSEP )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==OPENP) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:45: OPENP ( ( SEMI )* ( inline_option ) )* ( SEMI )* CLOSEP
                    {
                    match(input,OPENP,FOLLOW_OPENP_in_control345); 
                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:51: ( ( SEMI )* ( inline_option ) )*
                    loop25:
                    do {
                        int alt25=2;
                        alt25 = dfa25.predict(input);
                        switch (alt25) {
                    	case 1 :
                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:52: ( SEMI )* ( inline_option )
                    	    {
                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:52: ( SEMI )*
                    	    loop24:
                    	    do {
                    	        int alt24=2;
                    	        int LA24_0 = input.LA(1);

                    	        if ( (LA24_0==SEMI) ) {
                    	            alt24=1;
                    	        }


                    	        switch (alt24) {
                    	    	case 1 :
                    	    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:52: SEMI
                    	    	    {
                    	    	    match(input,SEMI,FOLLOW_SEMI_in_control348); 

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop24;
                    	        }
                    	    } while (true);

                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:58: ( inline_option )
                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:59: inline_option
                    	    {
                    	    pushFollow(FOLLOW_inline_option_in_control352);
                    	    inline_option();

                    	    state._fsp--;


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:76: ( SEMI )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==SEMI) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:57:76: SEMI
                    	    {
                    	    match(input,SEMI,FOLLOW_SEMI_in_control357); 

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    match(input,CLOSEP,FOLLOW_CLOSEP_in_control360); 

                    }
                    break;

            }

            match(input,AT,FOLLOW_AT_in_control364); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "control"


    // $ANTLR start "option_name"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:60:1: option_name : ID ;
    public final void option_name() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:61:3: ( ID )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:61:5: ID
            {
            match(input,ID,FOLLOW_ID_in_option_name377); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "option_name"


    // $ANTLR start "control_id"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:64:1: control_id : ID ;
    public final void control_id() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:65:3: ( ID )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:65:5: ID
            {
            match(input,ID,FOLLOW_ID_in_control_id392); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "control_id"


    // $ANTLR start "var_name"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:68:1: var_name : ( ( DOT )? ID )+ ;
    public final void var_name() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:69:3: ( ( ( DOT )? ID )+ )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:69:5: ( ( DOT )? ID )+
            {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:69:5: ( ( DOT )? ID )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                alt29 = dfa29.predict(input);
                switch (alt29) {
            	case 1 :
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:69:6: ( DOT )? ID
            	    {
            	    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:69:6: ( DOT )?
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==DOT) ) {
            	        alt28=1;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:69:6: DOT
            	            {
            	            match(input,DOT,FOLLOW_DOT_in_var_name408); 

            	            }
            	            break;

            	    }

            	    match(input,ID,FOLLOW_ID_in_var_name411); 

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "var_name"


    // $ANTLR start "option_value"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:72:1: option_value : ( ID | QUOTED );
    public final void option_value() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:73:3: ( ID | QUOTED )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:
            {
            if ( input.LA(1)==ID||input.LA(1)==QUOTED ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "option_value"


    // $ANTLR start "var_type"
    // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:76:1: var_type : ID ;
    public final void var_type() throws RecognitionException {
        try {
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:77:3: ( ID )
            // /Users/fox/workspace/libtoil/src/org/libtoil/core/ToilStatement.g:77:5: ID
            {
            match(input,ID,FOLLOW_ID_in_var_type445); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "var_type"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA29 dfa29 = new DFA29(this);
    static final String DFA3_eotS =
        "\4\uffff";
    static final String DFA3_eofS =
        "\4\uffff";
    static final String DFA3_minS =
        "\2\6\2\uffff";
    static final String DFA3_maxS =
        "\2\17\2\uffff";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA3_specialS =
        "\4\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1\1\2\7\uffff\1\3",
            "\1\1\1\2\7\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()* loopback of 25:24: ( ( SEMI )* ( inline_option ) )*";
        }
    }
    static final String DFA11_eotS =
        "\4\uffff";
    static final String DFA11_eofS =
        "\4\uffff";
    static final String DFA11_minS =
        "\2\6\2\uffff";
    static final String DFA11_maxS =
        "\2\17\2\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA11_specialS =
        "\4\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\1\1\2\1\uffff\1\2\2\1\3\uffff\1\3",
            "\1\1\1\2\1\uffff\1\2\2\1\3\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "()* loopback of 33:5: ( ( SEMI | EOL | WS )* ( header_variable | header_option ) )*";
        }
    }
    static final String DFA15_eotS =
        "\4\uffff";
    static final String DFA15_eofS =
        "\4\uffff";
    static final String DFA15_minS =
        "\2\5\2\uffff";
    static final String DFA15_maxS =
        "\2\17\2\uffff";
    static final String DFA15_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA15_specialS =
        "\4\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\2\2\3\1\uffff\1\3\2\1\3\uffff\1\3",
            "\1\2\2\3\1\uffff\1\3\2\1\3\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "37:37: ( ( EOL | WS )* OPENP header_declarations CLOSEP )?";
        }
    }
    static final String DFA20_eotS =
        "\4\uffff";
    static final String DFA20_eofS =
        "\4\uffff";
    static final String DFA20_minS =
        "\2\4\2\uffff";
    static final String DFA20_maxS =
        "\2\17\2\uffff";
    static final String DFA20_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA20_specialS =
        "\4\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\2\1\uffff\1\1\1\2\7\uffff\1\3",
            "\1\2\1\uffff\1\1\1\2\7\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "()* loopback of 45:5: ( ( SEMI )* ( inline_variable | inline_option ) )*";
        }
    }
    static final String DFA25_eotS =
        "\4\uffff";
    static final String DFA25_eofS =
        "\4\uffff";
    static final String DFA25_minS =
        "\2\6\2\uffff";
    static final String DFA25_maxS =
        "\2\17\2\uffff";
    static final String DFA25_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA25_specialS =
        "\4\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\1\1\2\7\uffff\1\3",
            "\1\1\1\2\7\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "()* loopback of 57:51: ( ( SEMI )* ( inline_option ) )*";
        }
    }
    static final String DFA29_eotS =
        "\14\uffff";
    static final String DFA29_eofS =
        "\14\uffff";
    static final String DFA29_minS =
        "\1\4\1\uffff\1\4\1\uffff\10\5";
    static final String DFA29_maxS =
        "\1\20\1\uffff\1\20\1\uffff\10\20";
    static final String DFA29_acceptS =
        "\1\uffff\1\2\1\uffff\1\1\10\uffff";
    static final String DFA29_specialS =
        "\14\uffff}>";
    static final String[] DFA29_transitionS = {
            "\4\1\1\uffff\3\1\3\uffff\1\2\1\3",
            "",
            "\4\3\1\uffff\2\3\1\4\2\1\1\uffff\2\3",
            "",
            "\3\3\1\uffff\2\3\1\6\2\1\1\uffff\1\5\1\1",
            "\3\1\1\uffff\2\1\1\7\2\3\1\uffff\2\1",
            "\3\3\1\uffff\2\3\1\6\1\1\2\uffff\1\5\1\1",
            "\3\1\1\uffff\2\1\1\10\2\3\1\uffff\1\11\1\3",
            "\3\1\1\uffff\2\1\1\10\1\3\2\uffff\1\11\1\3",
            "\3\3\1\uffff\2\3\1\12\2\1\1\uffff\2\3",
            "\3\3\1\uffff\2\3\1\13\2\1\1\uffff\1\5\1\1",
            "\3\3\1\uffff\2\3\1\13\1\1\2\uffff\1\5\1\1"
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "()+ loopback of 69:5: ( ( DOT )? ID )+";
        }
    }
 

    public static final BitSet FOLLOW_variable_in_statement42 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_control_in_statement46 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarations_in_statement50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_variable71 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_var_name_in_variable73 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_OPENP_in_variable76 = new BitSet(new long[]{0x00000000000080C0L});
    public static final BitSet FOLLOW_SEMI_in_variable79 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_inline_option_in_variable83 = new BitSet(new long[]{0x00000000000080C0L});
    public static final BitSet FOLLOW_SEMI_in_variable88 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_CLOSEP_in_variable91 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_AT_in_variable95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_declarations110 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_SEMI_in_declarations112 = new BitSet(new long[]{0x0000000000008150L});
    public static final BitSet FOLLOW_inline_declarations_in_declarations115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_OPENC_in_declarations121 = new BitSet(new long[]{0x0000000000008F40L});
    public static final BitSet FOLLOW_header_declarations_in_declarations124 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSEC_in_declarations126 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_AT_in_declarations132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_header_declarations146 = new BitSet(new long[]{0x0000000000008C40L});
    public static final BitSet FOLLOW_header_variable_in_header_declarations160 = new BitSet(new long[]{0x0000000000008C42L});
    public static final BitSet FOLLOW_header_option_in_header_declarations164 = new BitSet(new long[]{0x0000000000008C42L});
    public static final BitSet FOLLOW_set_in_header_declarations169 = new BitSet(new long[]{0x0000000000000C42L});
    public static final BitSet FOLLOW_var_type_in_header_variable193 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_set_in_header_variable195 = new BitSet(new long[]{0x0000000000019800L});
    public static final BitSet FOLLOW_var_name_in_header_variable204 = new BitSet(new long[]{0x0000000000000C22L});
    public static final BitSet FOLLOW_set_in_header_variable208 = new BitSet(new long[]{0x0000000000000C20L});
    public static final BitSet FOLLOW_OPENP_in_header_variable217 = new BitSet(new long[]{0x0000000000008CC0L});
    public static final BitSet FOLLOW_header_declarations_in_header_variable219 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_CLOSEP_in_header_variable221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_option_name_in_header_option236 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_WS_in_header_option238 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUALS_in_header_option241 = new BitSet(new long[]{0x0000000000028800L});
    public static final BitSet FOLLOW_WS_in_header_option243 = new BitSet(new long[]{0x0000000000028800L});
    public static final BitSet FOLLOW_option_value_in_header_option246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_inline_declarations260 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_inline_variable_in_inline_declarations264 = new BitSet(new long[]{0x0000000000008042L});
    public static final BitSet FOLLOW_inline_option_in_inline_declarations268 = new BitSet(new long[]{0x0000000000008042L});
    public static final BitSet FOLLOW_SEMI_in_inline_declarations273 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_var_type_in_inline_variable287 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_inline_variable289 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_var_name_in_inline_variable291 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_OPENP_in_inline_variable294 = new BitSet(new long[]{0x00000000000080C0L});
    public static final BitSet FOLLOW_inline_declarations_in_inline_variable296 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_CLOSEP_in_inline_variable298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_option_name_in_inline_option313 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUALS_in_inline_option315 = new BitSet(new long[]{0x0000000000028800L});
    public static final BitSet FOLLOW_option_value_in_inline_option317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_control331 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DOLLAR_in_control333 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_control_id_in_control335 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_COLON_in_control338 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_var_name_in_control340 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_OPENP_in_control345 = new BitSet(new long[]{0x00000000000080C0L});
    public static final BitSet FOLLOW_SEMI_in_control348 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_inline_option_in_control352 = new BitSet(new long[]{0x00000000000080C0L});
    public static final BitSet FOLLOW_SEMI_in_control357 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_CLOSEP_in_control360 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_AT_in_control364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_option_name377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_control_id392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_var_name408 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ID_in_var_name411 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_set_in_option_value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_var_type445 = new BitSet(new long[]{0x0000000000000002L});

}