package pocket.pvm.lang.type;

/**
 * Pocket int.
 */
public class PocketInt extends PocketNumber {
    protected final Integer value;

    public PocketInt(String value) {
        this.value = Integer.valueOf(value);
    }

    public PocketInt(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Int{%d}", value);
    }
}
