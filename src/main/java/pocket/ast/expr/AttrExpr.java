package pocket.ast.expr;

/**
 * Attribute expression. In Pocket, value and attribute are separated by dot sign.
 * @author James Chan
 * @example Console.print
 * @example this.userService.getId
 */
public class AttrExpr extends Expr {
    private final Expr value;

    private final String attr;

    public AttrExpr(Expr value, String attribute) {
        this.value = value;
        this.attr = attribute;
    }

    public Expr getValue() {
        return value;
    }

    public String getAttr() {
        return attr;
    }
}
