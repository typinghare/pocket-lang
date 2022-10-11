// Define a grammar called Hello

grammar Hello;

@header {
    package: antlr;
}

// start variable
prog : (decl | expr)+ EOF;

decl : ID '=' NUM
    | ID '=' STR
    | ID '=' DBL
    | ID '=' ID
    | ID '=' expr;
expr : expr '*' expr
    | expr '+' expr
    | expr '/' expr
    | expr '-' expr
    | ID
    | NUM
    | STR
    | DBL;

/* Tokens */
ID : [a-z][a-zA-Z0-9]*;
STR : '"' .*? '"';
SIGN : ('-' | '+')?;
NUM: '0' | (SIGN)[1-9][0-9]*;
DBL : '0.0' | (SIGN)[1-9][0-9]*'.'[0-9]*;
COMMENT : '//' ~[\r\n]* -> skip;
WS : [ \t\n]+ -> skip;

