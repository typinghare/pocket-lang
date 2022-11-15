package pocket.pvm;


import pocket.pvm.lang.BasicDataType;
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
     * Whether this symbol is const. The pocket object cannot be changed if true.
     */
    private final boolean isConst = false;

    /**
     * The basic date type of this object.
     */
    public final BasicDataType basicDataType;

    /**
     * Creates  a symbol
     * @param pocketObject  the initial pocket object
     * @param basicDataType basic data type
     */
    public Symbol(PocketObject pocketObject, BasicDataType basicDataType) {
        this.pocketObject = pocketObject;
        this.basicDataType = basicDataType;
    }

    public boolean setPocketObject(PocketObject pocketObject) {
        if (!isConst) return false;

        this.pocketObject = pocketObject;
        return true;
    }

    public PocketObject getPocketObject() {
        return pocketObject;
    }

    public boolean isConst() {
        return isConst;
    }

    public BasicDataType getBasicDataType() {
        return basicDataType;
    }

    @Override
    public String toString() {
        return pocketObject.toString();
    }
}
