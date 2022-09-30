package pocket.parser;

import java.util.regex.Pattern;

/**
 * @author James Chan
 */
public enum PatternTokenType implements TokenType {
    Int("-?[1-9][0-9]*"),
    Id("[A-Za-z_$][A-Za-z0-9_$]*");

    /**
     * The pattern of the token type.
     */
    final Pattern pattern;

    /**
     * Creates a pattern-based token type.
     * @param pattern the pattern string of the token type
     */
    PatternTokenType(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    @Override
    public Pattern getPattern() {
        return this.pattern;
    }
}
