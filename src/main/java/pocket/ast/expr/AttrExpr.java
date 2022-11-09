package pocket.ast.expr;

/**
 * Attribute expression. In Pocket, value and attribute are separated by dot sign.
 * @author James Chan
 * @example Console.print
 * @example this.userService.getId
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
