package pocket.pvm.evaluator;

import pocket.pvm.Evaluator;
import pocket.pvm.PocketVirtualMachine;
import pocket.pvm.lang.NativeFn;
import pocket.pvm.lang.type.PocketInt;
import pocket.pvm.lang.type.PocketObject;
import pocket.pvm.lang.type.PocketStr;

import java.util.List;

public class NativeFnEvaluator extends Evaluator {
    public NativeFnEvaluator(PocketVirtualMachine pocketVirtualMachine) {
        super(pocketVirtualMachine);
    }

    public PocketObject evaluate(NativeFn nativeFn, PocketObject thisObject, List<PocketObject> argumentValueList) {
        return switch (nativeFn) {
            case SystemOutPrint -> systemOutPrint(argumentValueList);
            case LengthOfString -> lengthOfString(thisObject);
        };
    }

    public PocketObject systemOutPrint(List<PocketObject> argumentValueList) {
        if (argumentValueList.size() == 0) {
            return new PocketStr("");
        }

        final StringBuilder stringBuilder = new StringBuilder();
        for (PocketObject argumentValue : argumentValueList) {
            stringBuilder.append(argumentValue.toString()).append(" ");
        }

        final String outputString = stringBuilder.substring(0, stringBuilder.length() - 1);
        System.out.println("[Console] " + outputString);

        return new PocketStr(outputString);
    }

    public PocketInt lengthOfString(PocketObject thisObject) {
        assert thisObject instanceof PocketStr;
        final int len = ((PocketStr) thisObject).getValue().length();

        return new PocketInt(len);
    }
}
