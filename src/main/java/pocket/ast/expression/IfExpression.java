package pocket.ast.expression;

/**
 * @author James Chan
 */
public class IfExpression extends Expression {
    Expression predicate;

    Expression body;

    Expression elseExpression;
}
