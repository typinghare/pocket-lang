package pocket.ast.expr;

import pocket.ast.op.BinaryOp;

/**
 * Binary expression.
 */
public class BinaryExpr extends Expr {
    /**
     * Operator.
     */
    private final BinaryOp op;

    /**
     * Left operand.
     */
    private final Expr left;

    /**
     * Right operand.
     */
    private final Expr right;

    public BinaryExpr(BinaryOp op, Expr left, Expr right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public BinaryOp getOp() {
        return op;
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }
}
