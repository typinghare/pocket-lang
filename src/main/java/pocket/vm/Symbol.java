package pocket.vm;

import pocket.vm.type.PocketObject;

public class Symbol {
    private PocketObject pocketObject;

    private boolean isAccessible = true;

    public String type;

    Symbol(PocketObject pocketObject) {
        this.pocketObject = pocketObject;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
