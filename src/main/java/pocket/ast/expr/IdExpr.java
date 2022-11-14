package pocket.ast.expr;

/**
 * Id expression.
 */
public class IdExpr extends Expr {
    private final String value;

    public IdExpr(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
