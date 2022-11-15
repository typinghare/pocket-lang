package pocket.pvm.evaluator;

import pocket.ast.expr.Expr;
import pocket.ast.expr.FnExpr;
import pocket.pvm.Evaluator;
import pocket.pvm.PocketVirtualMachine;
import pocket.pvm.lang.type.PocketFn;
import pocket.pvm.lang.type.PocketObject;

/**
 * Function expression evaluator.
 */
public class FnExprEvaluator extends Evaluator {
    public FnExprEvaluator(PocketVirtualMachine pocketVirtualMachine) {
        super(pocketVirtualMachine);
    }

    @Override
    public PocketObject evaluate(Expr expr) {
        assert expr instanceof FnExpr;

        return new PocketFn((FnExpr) expr, pocketVirtualMachine);
    }
}
