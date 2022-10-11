// Define a grammar called Hello

grammar Hello;

@header {
    package: antlr;
}

// start variable
prog : blockFn EOF;

blockFn: '{' (stmt)* '}';

decl : ID? (assign ',')* assign ';';

assign : ID '=' expr;

stmt : decl;

expr : expr ('*' | '/') expr
    | expr ('+' | '-') expr
    | ID
    | NUM
    | STR
    | FLT;

/* Tokens */
ID : [a-zA-Z_$][a-zA-Z0-9_$]*;
STR : '"' .*? '"';
SIGN : ('-' | '+');
NUM: '0' | (SIGN)?[1-9][0-9]*;
FLT : (SIGN)?([1-9][0-9]* | '0')'.'[0-9]*;
COMMENT : '//' ~[\r\n]* -> skip;
WS : [ \t\n]+ -> skip;