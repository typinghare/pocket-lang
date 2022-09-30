package pocket.parser;

/**
 * Line tokens will be generated during line parsing. Therefore, it does not contain the line number. The tokenizer
 * provides line token, hence, tokenizer does not perceive the line number and other information.
 * @author James Chan
 * @see Token
 * @see Tokenizer
 */
public class LineToken {
    /**
     * The type of this token.
     */
    final TokenType tokenType;

    /**
     * The lexeme of this token.
     */
    final String lexeme;

    /**
     * The number of column the first character of this token locates.
     */
    final int column;

    /**
     * Creates an elemental token with lexeme.
     * @param tokenType the type of this token.
     * @param lexeme    the lexeme of this token.
     * @param column    the number of column the first character of this token locates.
     */
    LineToken(TokenType tokenType, String lexeme, int column) {
        this.tokenType = tokenType;
        this.lexeme = lexeme;
        this.column = column;
    }

    /**
     * Creates an elemental token without lexeme.
     * @param tokenType the type of this token.
     * @param column    the number of column the first character of this token locates.
     */
    LineToken(TokenType tokenType, int column) {
        this(tokenType, null, column);
    }

    /**
     * Gets the lexeme of this token.
     * @return the lexeme of this token.
     */
    String getLexeme() {
        return lexeme == null ? tokenType.getPattern().toString() : lexeme;
    }

    /**
     * Gets the token type of this token.
     * @return the token type of this token.
     */
    public TokenType getTokenType() {
        return tokenType;
    }
}
