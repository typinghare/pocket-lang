package pocket.vm.evaluator;

import pocket.ast.expr.Expr;
import pocket.vm.type.PocketObject;

public abstract class Evaluator {
    /**
     * Evaluates an expression.
     * @param expr expression to evaluate
     * @return a pocket object
     */
    public abstract PocketObject eval(Expr expr);
}
