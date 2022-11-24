package pocket.pvm.evaluator;

import pocket.ast.expr.AttrExpr;
import pocket.ast.expr.Expr;
import pocket.pvm.Evaluator;
import pocket.pvm.PocketVirtualMachine;
import pocket.pvm.lang.type.PocketObject;

/**
 * Attribute expression evaluator.
 */
public class AttrExprEvaluator extends Evaluator {
    public AttrExprEvaluator(PocketVirtualMachine pocketVirtualMachine) {
        super(pocketVirtualMachine);
    }

    @Override
    public PocketObject evaluate(Expr expr) {
        assert expr instanceof AttrExpr;

        final PocketObject targetObject = super.evaluate(((AttrExpr) expr).getTarget());
        final String attr = ((AttrExpr) expr).getAttr().getValue();

        if (targetObject != null) {
            return targetObject.getField(attr);
        }

        return null;
    }
}
