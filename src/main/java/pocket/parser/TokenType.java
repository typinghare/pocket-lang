package pocket.parser;

/**
 * Well this should be an abstract class, but Java17 does not support enum extension so this is a
 * makeshift.
 * @author James Chan
 */
public interface TokenType extends Terminal {
    /**
     * Get the pattern of this token type.
     * @return the pattern of this token type.
     */
    public Object getPattern();
}
