package pocket.vm.type;

public class PocketFloat extends PocketNumber {
    protected Float value;

    public PocketFloat(String value) {
        this.value = Float.valueOf(value);
    }

    @Override
    public Float getValue() {
        return value;
    }
}
