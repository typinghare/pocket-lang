package pocket.ast2;

public class IdValue extends Value {
    private String name;

    public IdValue(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }
}
