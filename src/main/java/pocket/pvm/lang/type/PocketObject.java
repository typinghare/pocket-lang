package pocket.pvm.lang.type;

import pocket.pvm.cls.PocketField;

import java.util.HashMap;
import java.util.Map;

public class PocketObject {
    public final static PocketObject VOID = new PocketObject();

    /**
     * Pocket class this pocket object pertains to.
     */
    protected PocketClass pocketClass;

    /**
     * Field table of this pocket object.
     */
    private final Map<String, PocketField> fieldTable = new HashMap<>();

    /**
     * Puts a static field.
     * @param name         name of the field
     * @param pocketObject pocket object to bind
     * @param isFinal      whether the field is final
     */
    public void putField(String name, PocketObject pocketObject, boolean isFinal) {
        PocketField pocketField = fieldTable.get(name);
        if (pocketField == null) {
            pocketField = new PocketField(isFinal);
            pocketField.setPocketObject(pocketObject);
            fieldTable.put(name, pocketField);
        }

        pocketField.setPocketObject(pocketObject);
    }

    public PocketObject getField(String name) {
        return fieldTable.get(name).getPocketObject();
    }

    public void bindClass(PocketClass pocketClass) {
        this.pocketClass = pocketClass;
    }

    public PocketClass getPocketClass() {
        return pocketClass;
    }

    @Override
    public String toString() {
        return pocketClass == null ? "Object(unknown)" :
            String.format("Object(%s)", pocketClass.getName());
    }
}
