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

@lexer::members{
  boolean tagMode = false;
}

template
      : (EOL | text | statement | whitespace)*
      ;

whitespace
  : WS
  ;
  
  
text 
  : TEXT
  ;
  

statement
    : variable | control | declarations 
    ;

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
    : { tagMode }?=>  '{' 
  ;

CLOSEC 
    : { tagMode }?=> '}' 
  ;

OPENP
    : { tagMode }?=> '('
  ;

CLOSEP
    : { tagMode }?=>  ')'
  ;
  
EQUALS
    : { tagMode }?=> '='
  ;

COLON
    : { tagMode }?=> ':'
  ;

DOLLAR
    : { tagMode }?=> '$'
  ;

SEMI
    : { tagMode }?=> ';'
  ;
    
QUOTED 
    : { tagMode }?=>  '"' ~'"'* '"'
  ;
    
    
ID
    : { tagMode }?=> ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'/'|'-'|'.'|'~')*
  ;    

STATEMENT_LINE_CONTINUE 
    : { tagMode }?=> '\\' ( ' ' | '\t' )+ '\r'?  '\n' {$channel=HIDDEN;} 
  ; 
  
STATMENT_COMMENT 
    : { tagMode }?=> '#' ~('\r' | '\n')*  {$channel=HIDDEN;} 
    ;


LINE_CONTINUATION
  : '@' '\\' ( ' ' | '\t' )+ '\r'?  '\n'  {$channel=HIDDEN;} 
  ; 
  
LINE_COMMENT
  : '@' '#' ~('\r' | '\n')*  {$channel=HIDDEN;} 
  ;

AT
  : '@' { tagMode = !tagMode; } 
  ;
  
TEXT
: { !tagMode }?=> ~('\r' | '\n' |  ' ' | '\t' | '@')+
  ;
  
EOL
  : '\r'?  '\n'
  ; 
  
WS
  : ( ' ' | '\t' )+
  ;

  