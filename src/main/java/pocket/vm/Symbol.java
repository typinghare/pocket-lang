package pocket.vm;

import pocket.vm.type.PocketObject;

public class Symbol {
    private PocketObject pocketObject;

    private boolean isAccessible = true;

    public final Type type;

    public Symbol(PocketObject pocketObject, Type type) {
        this.pocketObject = pocketObject;
        this.type = type;
    }

    public boolean setPocketObject(PocketObject pocketObject) {
        if (!isAccessible) return false;

        this.pocketObject = pocketObject;
        return true;
    }

    public PocketObject getPocketObject() {
        return pocketObject;
    }

    public boolean isAccessible() {
        return isAccessible;
    }

    public void setAccessible(boolean accessible) {
        isAccessible = accessible;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
//        return String.format("%s(%s)", type.toString(), pocketObject.toString());
        return pocketObject.toString();
    }
}
