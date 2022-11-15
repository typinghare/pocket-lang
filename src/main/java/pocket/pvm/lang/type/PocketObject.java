package pocket.pvm.lang.type;

public class PocketObject {
    public final static PocketObject VOID = new PocketObject();

    protected Object value;

    public PocketObject(Object value) {
        this.value = value;
    }

    public PocketObject() {
        this(null);
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value == null ? null : value.toString();
    }
}
