package pocket.pvm.evaluator;

import pocket.ast.expr.CallExpr;
import pocket.ast.expr.Expr;
import pocket.pvm.Evaluator;
import pocket.pvm.PocketVirtualMachine;
import pocket.pvm.lang.type.PocketFn;
import pocket.pvm.lang.type.PocketNativeFn;
import pocket.pvm.lang.type.PocketObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Call expression evaluator.
 */
public class CallExprEvaluator extends Evaluator {
    public CallExprEvaluator(PocketVirtualMachine pocketVirtualMachine) {
        super(pocketVirtualMachine);
    }

    @Override
    public PocketObject evaluate(Expr expr) {
        assert expr instanceof CallExpr;

        final PocketObject target = super.evaluate(((CallExpr) expr).getTarget());
        final List<PocketObject> argList = new ArrayList<>();
        for (final Expr argExpr : ((CallExpr) expr).getArgList()) {
            argList.add(super.evaluate(argExpr));
        }

        if (target instanceof PocketNativeFn) {
            return ((PocketNativeFn) target).invoke(argList);
        } else if (target instanceof PocketFn) {
            return ((PocketFn) target).invoke(argList);
        } else {
            return null;
        }
    }
}
