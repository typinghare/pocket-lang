package pocket.pvm.lang.type;

public class PocketFloat extends PocketNumber {
    protected final Float value;

    public PocketFloat(String value) {
        this.value = Float.valueOf(value);
    }

    public PocketFloat(Float value) {
        this.value = value;
    }

    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Float{%f}", value);
    }
}
