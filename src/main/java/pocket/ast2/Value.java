package pocket.ast2;

/**
 * Raw value.
 * @author James Chan
 */
public class Value {
    private final String value;

    public Value(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
