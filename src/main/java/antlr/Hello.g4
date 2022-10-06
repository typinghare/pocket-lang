// Define a grammar called Hello

grammar Hello;

@header {
    package: antlr;
}

// start variable
prog: (decl | expr)+ EOF;

decl: ID ':' INT_TYPE '=' NUM;
expr: expr '*' expr
    | expr '+' expr
    | ID
    | NUM;

/* Tokens */
ID: [a-z][a-zA-Z0-9]*;
NUM: '0' | ('-' | '+')?[1-9][0-9]*;
INT_TYPE: 'INT';
COMMENT: '--' ~[\r\n]* -> skip;
WS: [ \t\n]+ -> skip;

