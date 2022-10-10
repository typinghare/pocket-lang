package pocket.ast.expression;

import pocket.ast.statement.Statement;

import java.util.List;

/**
 * Block function.
 * @author James Chan
 * @example { a = b + 1; }
 * @example { if (a > b) a = b; return a; }     // return statement included
 */
public class AnonymousBlockFunctionExpression extends Expression{
    List<Statement> statementList;

    Statement returnStatement;

    Statement breakStatement;

    Statement continueStatement;
}
