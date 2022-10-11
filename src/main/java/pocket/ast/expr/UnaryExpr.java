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
    private Op operator;

    /**
     * Operand.
     */
    private Expr operand;
}
