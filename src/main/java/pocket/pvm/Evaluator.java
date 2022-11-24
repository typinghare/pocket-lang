package pocket.pvm;

import pocket.ast.expr.Expr;
import pocket.pvm.lang.type.PocketObject;

public class Evaluator {
    protected final PocketVirtualMachine pocketVirtualMachine;

    public Evaluator(PocketVirtualMachine pocketVirtualMachine) {
        this.pocketVirtualMachine = pocketVirtualMachine;
    }

    /**
     * Evaluates an expression.
     * @param expr expression to execute
     * @return a pocket object yielded by the expression
     */
    public PocketObject evaluate(Expr expr) {
        if (expr == null)
            return null;

        return pocketVirtualMachine
                .getEvaluatorFactory()
                .getEvaluator(expr.getClass())
                .evaluate(expr);
    }
}

