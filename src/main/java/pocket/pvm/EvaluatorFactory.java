package pocket.pvm;

import pocket.ast.expr.*;
import pocket.pvm.evaluator.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Evaluator factory.
 */
public class EvaluatorFactory {
    private final Map<Class<? extends Expr>, Evaluator> exprClassEvaluatorMap = new HashMap<>();

    public EvaluatorFactory(PocketVirtualMachine pocketVirtualMachine) {
        // register evaluators here
        exprClassEvaluatorMap.put(IdExpr.class, new IdExprEvaluator(pocketVirtualMachine));
        exprClassEvaluatorMap.put(AttrExpr.class, new AttrExprEvaluator(pocketVirtualMachine));
        exprClassEvaluatorMap.put(TypeExpr.class, new TypeExprEvaluator(pocketVirtualMachine));
        exprClassEvaluatorMap.put(CallExpr.class, new CallExprEvaluator(pocketVirtualMachine));
        exprClassEvaluatorMap.put(FnExpr.class, new FnExprEvaluator(pocketVirtualMachine));
        exprClassEvaluatorMap.put(BinaryExpr.class, new BinaryExprEvaluator(pocketVirtualMachine));
    }

    /**
     * Returns an evaluator by a specified expression class.
     * @return the evaluator corresponding to the specified expression class
     */
    public Evaluator getEvaluator(Class<? extends Expr> exprClass) {
        return exprClassEvaluatorMap.get(exprClass);
    }
}
