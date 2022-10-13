package pocket.ast.expr;

import pocket.ast.type.Type;

public class TypeExpr extends Expr {
    private final Type type;

    public TypeExpr(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
