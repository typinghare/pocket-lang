package pocket.token;

public class Token {
    final TokenType tokenType;

    final String lexeme;

    final int line;

    final int column;

    public Token(TokenType tokenType, String lexeme, int line, int column) {
        this.tokenType = tokenType;
        this.lexeme = lexeme;
        this.line = line;
        this.column = column;
    }

    public Token(TokenType tokenType, int line, int column) {
        this(tokenType, null, line, column);
    }
}
