package pocket.vm.evaluator;

import pocket.ast.expr.Expr;
import pocket.ast.expr.TypeExpr;
import pocket.ast.type.*;
import pocket.vm.type.*;

public class TypeExprEvaluator extends Evaluator {
    @Override
    public PocketObject eval(Expr expr) {
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
        } else if (type instanceof NullType) {
            return new PocketNull();
        } else {
            return null;
        }
    }
}
