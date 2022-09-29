package pocket.parser;

import java.util.regex.Pattern;

/**
 * @author James Chan
 */
public enum StringTokenType implements TokenType {
    // `Newline` is special, it will not be passed to lexer
    Newline("\n"),

    // string-based token types
    // -- signs
    Plus("+"),
    Minus("-"),
    Star("*"),
    Slash("/"),
    Equal("="),
    LeftParentheses("\\("),
    RightParentheses("\\)"),

    // -- keywords
    If("if"),
    Else("else"),

    // regex-based token types
    Id("[\\w_$][\\w\\d_$]*");

    /**
     * The pattern of the token type.
     */
    public final Pattern pattern;

    /**
     * Creates a token type.
     * @param pattern the pattern string of the token type
     */
    StringTokenType(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }
}
