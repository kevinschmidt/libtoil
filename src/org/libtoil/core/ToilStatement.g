grammar ToilStatement;

options {
  language=Java; 
}

@header {
  package org.libtoil.core;
}

@lexer::header {
  package org.libtoil.core;
}

statement
    : variable | control | declarations 
    ;

// @;ordered-int-list:temperatures@ 
// @$foreach:temperatures(maxitems=3)@
// temp=@.(format="%4.2f")@
// @$end@

variable
  : AT var_name (OPENP (SEMI* (inline_option))* SEMI* CLOSEP)? AT
  ;
  
declarations
  : AT SEMI (inline_declarations | ( OPENC+ header_declarations CLOSEC+ )) AT
  ;

header_declarations
  : ((SEMI | EOL | WS)* (header_variable | header_option))* (SEMI | EOL | WS)*
  ;

header_variable
  : var_type (COLON | WS)+ var_name ( (EOL | WS)* OPENP header_declarations CLOSEP)?
  ;

header_option
  : option_name WS? EQUALS WS? option_value
  ;

inline_declarations
  : (SEMI* (inline_variable | inline_option))* SEMI*
  ;

inline_variable
  : var_type COLON var_name (OPENP inline_declarations CLOSEP)?
  ;

inline_option
  : option_name EQUALS option_value
  ;

control 
  : AT DOLLAR control_id (COLON var_name)? (OPENP (SEMI* (inline_option))* SEMI* CLOSEP)? AT
  ;

option_name
  : ID
  ;
  
control_id
  : ID
  ;
  
var_name
  : ID
  ;

option_value
  : ID | QUOTED
  ;
  
var_type
  : ID
  ;

OPENC
  : '{' 
  ;

CLOSEC
  : '}'
  ;

OPENP
  : '('
  ;

CLOSEP
  : ')'
  ;
  
EQUALS
  : '='
  ;

COLON
  : ':'
  ;

DOLLAR
  : '$'
  ;

HASH
  : '#'
  ;

SEMI
  : ';'
  ;
    
AT
  : '@'
  ;
    
QUOTED
  : '"' ~'"'* '"' 
  ;
    
ID
  : ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'/'|'-'|'.'|'~')*
  ;    

EOL
  : '\r'?  '\n'
  ; 
  
WS
  : ( ' ' | '\t' )+
  ;
  
COMMENT 
    : '#' ~('\r' | '\n')*  {$channel=HIDDEN;} 
    ;
  