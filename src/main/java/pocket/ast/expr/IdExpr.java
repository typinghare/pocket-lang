package pocket.ast.expr;

/**
 * Expression that consists of only one identifier token.
 */
public class IdExpr extends Expr {
    private final String lexeme;

    public IdExpr(String lexeme) {
        this.lexeme = lexeme;
    }

    public String getLexeme() {
        return lexeme;
    }
}
