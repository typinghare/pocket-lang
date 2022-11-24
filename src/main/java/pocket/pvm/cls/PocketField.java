package pocket.pvm.cls;

import pocket.pvm.lang.type.PocketObject;

public class PocketField {
    private boolean isFinal;

    private PocketObject pocketObject;

    public PocketField(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public void setPocketObject(PocketObject pocketObject) {
        if (!isFinal) {
            throw new RuntimeException("Cannot change the value because it is final.");
        }

        this.pocketObject = pocketObject;
    }

    public PocketObject getPocketObject() {
        return pocketObject;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        this.isFinal = true;
    }
}
