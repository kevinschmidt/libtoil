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
//      : ( whitespace | text | statement | EOL)*
      : statement+
      ;

whitespace
  : WS
  ;
  
  
//text 
//  : TEXT
//  ;
  

statement
//    : variable | control | declarations 
    : declaration_statement 
    ;

/*
variable
  : AT var_name (OPENP (SEMI* (inline_option))* SEMI* CLOSEP)? AT
  ;
  
  control 
  : AT DOLLAR control_id (COLON var_name)? (OPENP (SEMI* (inline_option))* SEMI* CLOSEP)? AT
  ;
*/
  
declaration_statement
  : AT DECL_SEP OPENC? declarations CLOSEC? AT
  ;

declarations
  : declaration (DECL_SEP* declaration)*
  ;

declaration
  : variable | option
  ;

variable
  : var_type VAR_SEP var_name ( OPENP declarations CLOSEP )? 
  ;

option
  : option_name OPT_SEP option_value
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

OPT_SEP
    : { statementMode && headerMode }?=> (WS+ '=' WS+)
    | { statementMode && !headerMode }?=> '='
    ;

VAR_SEP
    : { statementMode && headerMode }?=> (WS+ ':' WS+)
    | { statementMode && !headerMode }?=> ':'
    ;

DECL_SEP
    : { statementMode && headerMode }?=> ( ';' | WS | EOL)+
    | { statementMode && !headerMode }?=> ';'
  ;
    
OPENC 
    : { statementMode }?=> ( '{'+ DECL_SEP* ) { headerMode = true; } 
  ;

CLOSEC 
    : { statementMode }?=> ( DECL_SEP* '}'+ ) { headerMode = false; } 
  ;

OPENP
    : { statementMode && headerMode }?=> ( WS+ '(' DECL_SEP* )
    | { statementMode && !headerMode }?=> ( '(' DECL_SEP* )
  ; 

CLOSEP
    : { statementMode }?=>  DECL_SEP* ')'
  ;

DOLLAR
    : { statementMode }?=> '$'
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
  
//TEXT
//: { !statementMode }?=> ~('\r' | '\n' |  ' ' | '\t' | '@')+
//  ;
  
EOL
  : '\r'?  '\n'
  ; 
  
WS
  : ( ' ' | '\t' )+
  ;

  