package pocket.parser;

/**
 * Non-terminal symbol.
 * @author James Chan
 */
public enum NonTerminal implements Notation, ParseUnit {
    Stmt, Term;

    /**
     * The label fo this symbol.
     */
    final String label;

    /**
     * Creates a non-terminal symbol.
     */
    NonTerminal() {
        this.label = name();
    }

    @Override
    public String toString() {
        return this.label;
    }
}
