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
  boolean statementMode = false;
  boolean headerMode = false;
}

template
      : ( text | statement | whitespace |EOL)*
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

/*
variable
  : AT var_name (OPENP (SEMI* (inline_option))* SEMI* CLOSEP)? AT
  ;
  
  control 
  : AT DOLLAR control_id (COLON var_name)? (OPENP (SEMI* (inline_option))* SEMI* CLOSEP)? AT
  ;
*/
  
declarations
  : AT SEMI OPENC+ declaration? (DECL_SEP declaration)* CLOSEC+  AT
  ;

declarations
  : (variable | option)?
  ;

variable
  : var_type COLON var_name  /*( (EOL | WS)* OPENP header_declarations CLOSEP)? */
  ;

option
  : option_name EQUALS option_value
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
    : { statementMode }?=>  '{' 
  ;

CLOSEC 
    : { statementMode }?=> '}' 
  ;

OPENP
    : { statementMode }?=> '('
  ;

CLOSEP
    : { statementMode }?=>  ')'
  ;
  
EQUALS
    : { statementMode }?=> '='
  ;

COLON
    : { statementMode }?=> ':'
  ;

DOLLAR
    : { statementMode }?=> '$'
  ;

SEMI
    : { statementMode }?=> ';'
  ;
    
QUOTED 
    : { statementMode }?=>  '"' ~'"'* '"'
  ;
    
    
ID
    : { statementMode }?=> ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'/'|'-'|'.'|'~')*
  ;    

STATEMENT_LINE_CONTINUE 
    : { statementMode }?=> '\\' ( ' ' | '\t' )+ '\r'?  '\n' {$channel=HIDDEN;} 
  ; 
  
STATMENT_COMMENT 
    : { statementMode }?=> '#' ~('\r' | '\n')*  {$channel=HIDDEN;} 
    ;


LINE_CONTINUATION
  : '@' '\\' ( ' ' | '\t' )+ '\r'?  '\n'  {$channel=HIDDEN;} 
  ; 
  
LINE_COMMENT
  : '@' '#' ~('\r' | '\n')*  {$channel=HIDDEN;} 
  ;

AT
  : '@' { statementMode = !statementMode; } 
  ;
  
TEXT
: { !statementMode }?=> ~('\r' | '\n' |  ' ' | '\t' | '@')+
  ;
  
EOL
  : '\r'?  '\n'
  ; 
  
WS
  : ( ' ' | '\t' )+
  ;

  