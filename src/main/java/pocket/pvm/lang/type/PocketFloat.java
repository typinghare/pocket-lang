package pocket.pvm.lang.type;

public class PocketFloat extends PocketNumber {
    public final static PocketClass floatPocketClass = new PocketClass(PocketClass.objectPocketClass, "Float");

    protected final Float value;

    public PocketFloat(String value) {
        this(Float.valueOf(value));
    }

    public PocketFloat(Float value) {
        this.value = value;
        this.pocketClass = floatPocketClass;
    }

    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Float(%f)", value);
    }
}
