grammar test;

LINE 
: (WHITESPACE | TEXTLITERAL)+ EOL
	;
	

COMMENT
    :   '@#' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
    
LINE_CONTINUATION
    :   '@\\' ( ' '|'\t')* '\r'? '\n' {$channel=HIDDEN;}
;

EOL
    :   '\r'? '\n'
;

WHITESPACE
: ( ' '|'\t')+
	;
	
TEXTLITERAL
: ~('\n'|'\r'|  ' '|'\t' | '@' )
 ;
 
	