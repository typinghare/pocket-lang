package pocket.ast.type;

import pocket.ast.Node;

/**
 * Literal container.
 */
public abstract class Type extends Node {
    /**
     * The lexeme of this type.
     */
    protected final String literal;

    public Type(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
