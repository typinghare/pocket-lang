package pocket.pvm.lang.type;

import pocket.pvm.evaluator.NativeFnEvaluator;
import pocket.pvm.lang.NativeFn;

import java.util.List;

public class PocketNativeFn extends PocketObject {
    private final NativeFn nativeFn;

    private PocketObject thisObject;

    private final NativeFnEvaluator nativeFnEvaluator = new NativeFnEvaluator(null);

    public PocketNativeFn(NativeFn nativeFn, PocketObject thisObject) {
        this.nativeFn = nativeFn;
        this.thisObject = thisObject;
    }

    public PocketNativeFn(NativeFn nativeFn) {
        this(nativeFn, null);
    }

    public void bind(PocketObject thisObject) {
        this.thisObject = thisObject;
    }

    public PocketObject invoke(List<PocketObject> argumentValueList) {
        return nativeFnEvaluator.evaluate(nativeFn, thisObject, argumentValueList);
    }

    @Override
    public String toString() {
        return String.format("NativeFn(%s)", nativeFn.name());
    }
}
