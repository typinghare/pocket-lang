package pocket.ast.expr;

import pocket.ast.operator.Op;

/**
 * A unary expression contains one operand and a unary operator.
 * @author James Chan
 */
public class UnaryExpr extends Expr {
    /**
     * Operator.
     */
    private final Op operator;

    /**
     * Operand.
     */
    private final Expr operand;

    public UnaryExpr(Op operator, Expr operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public Op getOperator() {
        return operator;
    }

    public Expr getOperand() {
        return operand;
    }
}
