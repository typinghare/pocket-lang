package pocket.parser;

public class ElementalToken {
    /**
     * The type of this token.
     */
    final TokenType tokenType;

    /**
     * The lexeme of this token.
     */
    final String lexeme;

    /**
     * Creates an elemental token with lexeme.
     * @param tokenType the type of this token.
     * @param lexeme    the lexeme of this token.
     */
    ElementalToken(TokenType tokenType, String lexeme) {
        this.tokenType = tokenType;
        this.lexeme = lexeme;
    }

    /**
     * Creates an elemental token without lexeme.
     * @param tokenType the type of this token.
     */
    ElementalToken(TokenType tokenType) {
        this(tokenType, null);
    }

    /**
     * Gets the lexeme of this token.
     * @return the lexeme of this token.
     */
    String getLexeme() {
        return lexeme == null ? this.tokenType.pattern : lexeme;
    }
}
