package pocket.pvm;


import pocket.pvm.lang.type.PocketClass;
import pocket.pvm.lang.type.PocketObject;

/**
 * Symbol.
 */
public class Symbol {
    /**
     * The pocket object this symbol contains.
     */
    private PocketObject pocketObject;

    /**
     * Whether this symbol is a constant. The pocket object cannot be changed if it is true.
     */
    private final boolean isConst = false;

    /**
     * Creates  a symbol
     * @param pocketObject the initial pocket object
     */
    public Symbol(PocketObject pocketObject) {
        this.pocketObject = pocketObject;
    }

    public boolean setPocketObject(PocketObject pocketObject) {
        if (isConst) return false;

        this.pocketObject = pocketObject;
        return true;
    }

    public PocketObject getPocketObject() {
        return pocketObject;
    }

    public boolean isConst() {
        return isConst;
    }

    public PocketClass getType() {
        return pocketObject.getPocketClass();
    }

    @Override
    public String toString() {
        return pocketObject.toString();
    }
}
