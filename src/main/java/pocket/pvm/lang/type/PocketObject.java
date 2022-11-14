package pocket.pvm.lang.type;

public class PocketObject {
    protected Object value;

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value == null ? null : value.toString();
    }
}
