package pocket.ast.type;

import pocket.ast.Node;

public abstract class Type extends Node {
    /**
     * The lexeme of this type.
     */
    protected String lexeme;

    public Type(String lexeme) {
        this.lexeme = lexeme;
    }

    public String getLexeme() {
        return lexeme;
    }
}
