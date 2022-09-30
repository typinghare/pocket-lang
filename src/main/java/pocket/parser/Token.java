package pocket.parser;

import colorful.Color;

/**
 * @author James Chan
 */
public class Token extends LineToken {
    /**
     * The number of line the first character of this token locates.
     */
    final int line;

    /**
     * Creates a token.
     * @param tokenType the type of this token.
     * @param lexeme    the lexeme of this token.
     * @param line      the number of line the first character of this token locates.
     */
    Token(TokenType tokenType, String lexeme, int column, int line) {
        super(tokenType, lexeme, column);
        this.line = line;
    }

    /**
     * Creates a token based on a line token.
     * @param lineToken the line token to be cloned
     * @param line      the number of line the first character of this token locates.
     */
    Token(LineToken lineToken, int line) {
        this(lineToken.tokenType, lineToken.lexeme, lineToken.column, line);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Color.yellow('<'));

        if (tokenType instanceof StringTokenType) {
            stringBuilder.append(Color.cyan(tokenType.getPattern()));
        } else if (tokenType instanceof PatternTokenType) {
            stringBuilder.append(Color.red(tokenType.toString()))
                    .append(", ")
                    .append(Color.cyan(this.lexeme));
        } else {
            return "";
        }

        stringBuilder.append(Color.yellow('>'));
        return stringBuilder.toString();
    }
}
