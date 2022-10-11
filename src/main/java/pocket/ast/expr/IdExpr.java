package pocket.ast.expr;

/**
 * Expression that consists of only one identifier token.
 */
public class IdExpr extends Expr {
    private String lexeme;

    public String getValue() {
        return lexeme;
    }
}
