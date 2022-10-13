// Define a grammar called Hello

grammar Grammar;

@header {
    package: antlr;
}

// start variable
file : blockFn EOF;

/* Statements */
stmt : declStmt | rtnStmt | callExpr;
declStmt : ID? (assign ',')* assign ';';
rtnStmt : RETURN expr? ';';
assign : ID '=' expr;

/* Experesions */
expr : expr ('--' | '++')
    | ('++' | '--' | '!') expr
    | expr ('*' | '/' | '%') expr
    | expr ('+' | '-') expr
    | expr ('>=' | '>' | '<' | '<=') expr
    | expr ('==' | '!=') expr
    | ID
    | NUM
    | STR
    | FLT
    | fn
    | blockFn;
callExpr : attrExpr '(' (expr ',')* expr? ')' ';';
attrExpr : (ID) '.' (attrExpr | ID);

/* Functions */
blockFn : '{' (stmt)* '}';
fn : (ID param? | VOID? param?) blockFn;
param : '(' (ID ID ',')* (ID ID)? ')';

/* keywords */
VOID: 'void';
RETURN : 'return';

/* Tokens */
ID : [a-zA-Z_$][a-zA-Z0-9_$]*;
STR : '"' .*? '"';
SIGN : ('-' | '+');
NUM: '0' | (SIGN)?[1-9][0-9]*;
FLT : (SIGN)?([1-9][0-9]* | '0')'.'[0-9]*;
COMMENT : '//' ~[\r\n]* -> skip;
WS : [ \t\n]+ -> skip;