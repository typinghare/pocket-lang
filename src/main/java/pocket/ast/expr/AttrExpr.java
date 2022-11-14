package pocket.ast.expr;

/**
 * Attribute expression.
 */
public class AttrExpr extends Expr {
    private final Expr target;

    private final IdExpr attr;

    public AttrExpr(Expr target, IdExpr attr) {
        this.target = target;
        this.attr = attr;
    }

    public Expr getTarget() {
        return target;
    }

    public IdExpr getAttr() {
        return attr;
    }
}
