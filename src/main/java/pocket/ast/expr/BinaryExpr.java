package pocket.ast.expr;

import pocket.ast.op.BinaryOp;

/**
 * Binary expression.
 */
public class BinaryExpr extends Expr {
    /**
     * Operator.
     */
    private final BinaryOp operator;

    /**
     * Left operand.
     */
    private final Expr left;

    /**
     * Right operand.
     */
    private final Expr right;

    public BinaryExpr(BinaryOp operator, Expr left, Expr right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public BinaryOp getOperator() {
        return operator;
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }
}
