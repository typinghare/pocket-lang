package pocket.parser;

/**
 * @author James Chan
 */
public enum StringTokenType implements TokenType {
    // `Newline` is a special token, it will not be passed to lexers
    Newline("\n"),

    // signs
    Plus("+"),
    Minus("-"),
    Star("*"),
    Slash("/"),
    Equal("="),
    LeftParentheses("("),
    RightParentheses(")"),

    // keywords
    If("if"),
    Else("else");

    /**
     * The pattern string of this token type.
     */
    final String pattern;

    /**
     * Creates a string-based token type.
     * @param pattern the pattern string of this token type
     */
    StringTokenType(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }
}
