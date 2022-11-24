package pocket.pvm.lang.type;

/**
 * Pocket int.
 */
public class PocketInt extends PocketNumber {
    public final static PocketClass intPocketClass = new PocketClass(PocketClass.objectPocketClass, "Int");

    protected final Integer value;

    public PocketInt(String value) {
        this(Integer.valueOf(value));
    }

    public PocketInt(Integer value) {
        this.value = value;
        this.pocketClass = intPocketClass;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Int(%d)", value);
    }
}
