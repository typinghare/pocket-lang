package pocket.ast.expr;

import pocket.ast.operator.BinaryOp;

/**
 * A binary expression contains two operands separated by one operator.
 * @author James Chan
 */
public class BinaryExpr extends Expr {
    /**
     * Operator.
     */
    private BinaryOp operator;

    /**
     * Left operand.
     */
    private Expr left;

    /**
     * Right operand.
     */
    private Expr right;
}
