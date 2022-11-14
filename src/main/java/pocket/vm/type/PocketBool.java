package pocket.vm.type;

public class PocketBool extends PocketObject {
    private final Boolean value;

    public PocketBool(String value) {
        this.value = Boolean.valueOf(value);
    }

    public PocketBool(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Bool{%s}", value);
    }
}
