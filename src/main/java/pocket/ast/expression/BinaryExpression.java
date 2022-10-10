package pocket.ast.expression;

import pocket.ast.operator.Operator;

/**
 * A binary expression contains two operands separated by one operator.
 * @author James Chan
 */
public class BinaryExpression extends Expression {
    /**
     * Operator.
     */
    Operator operator;

    /**
     * Left operand.
     */
    Expression left;

    /**
     * Right operand.
     */
    Expression right;
}
