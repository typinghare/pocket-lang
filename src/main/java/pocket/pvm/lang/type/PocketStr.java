package pocket.pvm.lang.type;

import pocket.pvm.lang.NativeFn;

public class PocketStr extends PocketObject {
    public final static PocketClass strPocketClass = new PocketClass(PocketClass.objectPocketClass, "Str");

    private final String value;

    public PocketStr(String value) {
        this.value = value;
        this.pocketClass = strPocketClass;

        putField("length", new PocketNativeFn(NativeFn.LengthOfString, this), true);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Str{\"%s\"}", value);
    }
}
