package pocket.pvm.evaluator;

import pocket.ast.expr.Expr;
import pocket.ast.expr.IdExpr;
import pocket.pvm.Evaluator;
import pocket.pvm.PocketVirtualMachine;
import pocket.pvm.lang.type.PocketObject;

/**
 * Id expression evaluator.
 */
public class IdExprEvaluator extends Evaluator {
    public IdExprEvaluator(PocketVirtualMachine pocketVirtualMachine) {
        super(pocketVirtualMachine);
    }

    @Override
    public PocketObject evaluate(Expr expr) {
        assert expr instanceof IdExpr;

        return null;
    }
}
