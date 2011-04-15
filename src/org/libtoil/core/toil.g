grammar toil;

statement
    : variable | declarations | control
    ;

variable
  : AT ID AT
  ;
  
declarations
	: AT SEMI (inline_declarations | ( OPENC+ header_declarations CLOSEC+ )) AT
	;

header_declarations
	: ((SEMI | EOL)* h_declaration)* (SEMI | EOL)*
	;

h_declaration
	: h_var_decl | h_opt_del
	;

h_var_decl
	: type_id WS? COLON WS? var_id WS? (OPENP header_declarations CLOSEP)?
	;

h_opt_del
	: opt_id WS? EQUALS WS? value_id
	;

inline_declarations
	: (SEMI* i_declaration)* SEMI*
	;

i_declaration
	: i_var_decl | i_opt_del
	;

i_var_decl
	: type_id COLON var_id (OPENP inline_declarations CLOSEP)?
	;

i_opt_del
	: opt_id EQUALS value_id
	;

control :
  : AT DOLLAR control_id (COLON var_id)? AT
  ;

opt_id
  : ID
  ;
  
control_id
  : ID
  ;
  
var_id
  : ID
  ;

value_id
  : ID | QUOTED
  ;
  
type_id
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
  : '"' ( ESCAPE | ~('"'|'\\') )* '"'   ;
    
protected
ESCAPE
    :    '\\'
         ( 'n' { $setText("\n"); }
         | 'r' { $setText("\r"); }
         | 't' { $setText("\t"); }
         | '"' { $setText("\""); }
         )
    ;    
    
    
ID
	: ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;    

EOL
	: WS? '\r'?  '\n' WS?
	;	
	
WS
	: ( ' ' | '\t' )+
	;
	