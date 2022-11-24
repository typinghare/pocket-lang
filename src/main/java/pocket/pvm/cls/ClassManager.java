package pocket.pvm.cls;

import pocket.pvm.lang.NativeFn;
import pocket.pvm.lang.type.*;

import java.util.HashMap;
import java.util.Map;

public class ClassManager {
    /**
     * Mapping: class name => pocket class object
     */
    private final Map<String, PocketClass> pocketClassMap = new HashMap<>();

    public ClassManager() {
        pocketClassMap.put("Object", PocketClass.objectPocketClass);

        // Console
        final PocketClass consolePocketClass = new PocketClass(PocketClass.objectPocketClass, "Console");
        pocketClassMap.put("Console", consolePocketClass);
        consolePocketClass.putField("print", new PocketNativeFn(NativeFn.SystemOutPrint), true);

        // basic data type
        pocketClassMap.put("Int", PocketInt.intPocketClass);
        pocketClassMap.put("Float", PocketFloat.floatPocketClass);
        pocketClassMap.put("Str", PocketStr.strPocketClass);
        pocketClassMap.put("Bool", PocketBool.boolPocketClass);
    }

    public PocketClass getPocketClass(String name) {
        return pocketClassMap.get(name);
    }
}
