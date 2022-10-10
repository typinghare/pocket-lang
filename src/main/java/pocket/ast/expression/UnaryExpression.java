package pocket.ast.expression;

import pocket.ast.operator.Operator;

/**
 * A unary expression contains one operand and a unary operator.
 * @author James Chan
 */
public class UnaryExpression extends Expression {
    /**
     * Operator.
     */
    Operator operator;

    /**
     * Operand.
     */
    Expression operand;
}
