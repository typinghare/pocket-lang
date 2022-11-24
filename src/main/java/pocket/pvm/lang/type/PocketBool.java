package pocket.pvm.lang.type;

public class PocketBool extends PocketObject {
    public final static PocketClass boolPocketClass = new PocketClass(PocketClass.objectPocketClass, "Bool");

    private final Boolean value;

    public PocketBool(String value) {
        this(Boolean.valueOf(value));
    }

    public PocketBool(Boolean value) {
        this.value = value;
        this.pocketClass = boolPocketClass;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Bool(%s)", value);
    }
}
