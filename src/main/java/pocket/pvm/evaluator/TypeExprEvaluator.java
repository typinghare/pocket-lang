package pocket.pvm.evaluator;

import pocket.ast.expr.Expr;
import pocket.ast.expr.TypeExpr;
import pocket.ast.type.*;
import pocket.pvm.Evaluator;
import pocket.pvm.PocketVirtualMachine;
import pocket.pvm.lang.type.*;

/**
 * Type expression evaluator.
 */
public class TypeExprEvaluator extends Evaluator {
    public TypeExprEvaluator(PocketVirtualMachine pocketVirtualMachine) {
        super(pocketVirtualMachine);
    }

    @Override
    public PocketObject evaluate(Expr expr) {
        assert expr instanceof TypeExpr;

        final Type type = ((TypeExpr) expr).getType();
        final String literal = type.getLiteral();

        if (type instanceof IntType) {
            return new PocketInt(literal);
        } else if (type instanceof FloatType) {
            return new PocketFloat(literal);
        } else if (type instanceof StrType) {
            return new PocketStr(literal);
        } else if (type instanceof BoolType) {
            return new PocketBool(literal);
        } else {
            return null;
        }
    }
}
