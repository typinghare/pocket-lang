package pocket.vm.type;

public class PocketStr extends PocketObject {
    private final String value;

    public PocketStr(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Str{\"%s\"}", value);
    }
}
