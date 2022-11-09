package pocket.ast.expr;

/**
 * Expression that consists of only one identifier token.
 */
public class IdExpr extends Expr {
    private final String value;

    public IdExpr(String lexeme) {
        this.value = lexeme;
    }

    public String getLexeme() {
        return value;
    }
}
