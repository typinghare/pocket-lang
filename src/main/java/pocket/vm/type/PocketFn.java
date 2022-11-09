package pocket.vm.type;

import pocket.ast.expr.Expr;

public class PocketFn extends PocketObject {
    private final Expr expr;

    public PocketFn(Expr expr) {
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }
}
