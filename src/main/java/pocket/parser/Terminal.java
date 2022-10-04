package pocket.parser;

/**
 * Terminal symbol.
 * @author James Chan
 */
public interface Terminal extends Notation {
    /**
     * A special terminal.
     */
    Terminal EmptyString = new Terminal() {
    };
}
