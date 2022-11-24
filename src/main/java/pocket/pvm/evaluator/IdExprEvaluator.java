package pocket.pvm.evaluator;

import pocket.ast.expr.Expr;
import pocket.ast.expr.IdExpr;
import pocket.pvm.Evaluator;
import pocket.pvm.PocketVirtualMachine;
import pocket.pvm.Symbol;
import pocket.pvm.lang.type.PocketObject;

import java.util.Optional;

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

        final String id = ((IdExpr) expr).getValue();
        final Optional<Symbol> symbol = pocketVirtualMachine.getCurScope().getSymbol(id);

        return symbol.map(Symbol::getPocketObject).orElse(null);
    }
}
