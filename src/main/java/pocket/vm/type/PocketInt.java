package pocket.vm.type;

/**
 * Pocket Int type. Currently only support 32 bits integer from -2^31 to 2^31 - 1.
 * @author James Chan
 */
public class PocketInt extends PocketNumber {
    protected Integer value;

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
