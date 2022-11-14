package pocket.vm;

import pocket.ast.expr.AttrExpr;
import pocket.ast.expr.BinaryExpr;
import pocket.ast.expr.Expr;
import pocket.ast.expr.TypeExpr;
import pocket.vm.evaluator.AttrExprEvaluator;
import pocket.vm.evaluator.BinaryExprEvaluator;
import pocket.vm.evaluator.Evaluator;
import pocket.vm.evaluator.TypeExprEvaluator;

import java.util.HashMap;
import java.util.Map;

public class EvaluatorFactory {
    private final Map<Class<? extends Expr>, Evaluator> map = new HashMap<>();

    public EvaluatorFactory() {
        // register evaluator here
        map.put(AttrExpr.class, new AttrExprEvaluator());
        map.put(BinaryExpr.class, new BinaryExprEvaluator());
        map.put(TypeExpr.class, new TypeExprEvaluator());

    }

    /**
     * Returns a proper evaluator.
     */
    public Evaluator getEvaluator(Expr expression) {
        return map.get(expression.getClass());
    }
}
