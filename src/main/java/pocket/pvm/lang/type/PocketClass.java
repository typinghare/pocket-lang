package pocket.pvm.lang.type;

public class PocketClass extends PocketObject {
    public final static PocketClass classPocketClass = new PocketClass(null, "Class");

    public final static PocketClass objectPocketClass = new PocketClass(null, "Object");

    private final PocketClass parent;

    private final String name;

    public PocketClass(PocketClass parent, String name) {
        super();
        this.parent = parent;
        this.name = name;
        this.pocketClass = classPocketClass;
    }

    public PocketClass getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    /**
     * Whether a target instance of a specified class.
     */
    public boolean isInstanceof(PocketClass target) {
        if (equals(target))
            return true;

        PocketClass parent = this.parent;

        while (parent != null) {
            if (parent.equals(target)) return true;
            parent = parent.parent;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("Class(%s)", name);
    }
}
