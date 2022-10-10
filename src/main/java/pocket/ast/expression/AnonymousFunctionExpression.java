package pocket.ast.expression;

import pocket.ast.statement.ParameterStatement;

import java.util.List;

/**
 * Parametric function.
 * @author James Chan
 * @example (Int a, Int b) { if (a > b) return a; else return b; }
 */
public class AnonymousFunctionExpression extends AnonymousBlockFunctionExpression {
    List<ParameterStatement> parameterStatementList;
}
