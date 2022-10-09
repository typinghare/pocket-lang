package pocket.ast2;

/**
 * The value of a non-leaf node of an AST should be an operator.
 * @author James Chan
 */
public class Operator implements LogicUnit {
    public final String lexeme;

    protected Operator(String lexeme) {
        this.lexeme = lexeme;
    }

    public String getLexeme() {
        return lexeme;
    }
}
