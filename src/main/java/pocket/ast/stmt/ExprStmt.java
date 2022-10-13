package pocket.ast.stmt;

import pocket.ast.expr.Expr;

/**
 * An expression-like statement
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
