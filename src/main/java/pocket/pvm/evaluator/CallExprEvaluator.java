package pocket.pvm.evaluator;

import pocket.ast.expr.CallExpr;
import pocket.ast.expr.Expr;
import pocket.pvm.Evaluator;
import pocket.pvm.PocketVirtualMachine;
import pocket.pvm.lang.type.PocketObject;

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

        return null;
    }
}
