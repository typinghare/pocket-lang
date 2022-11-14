package pocket.ast.stmt;

import pocket.ast.expr.Expr;

/**
 * Expression statement.
 */
public class ExprStmt extends Stmt {
    private final Expr expr;

    public ExprStmt(Expr expr) {
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }
}
