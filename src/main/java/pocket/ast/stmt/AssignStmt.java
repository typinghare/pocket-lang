package pocket.ast.stmt;

import pocket.ast.expr.AttrExpr;
import pocket.ast.expr.Expr;

import java.util.List;

/**
 * @author James Chan
 * @example a = b + 2;  // type is omitted; implicit declaration
 * @example Int a = b + 2;   // declaration assignment
 * @example Int a = 1, b = 2;   // declaration with two targets and values
 */
public class AssignStmt extends Stmt {
    private final Expr type;

    private final List<Expr> target;

    private final List<Expr> value;

    public AssignStmt(Expr type, List<Expr> target, List<Expr> value) {
        this.type = type;
        this.target = target;
        this.value = value;
    }

    public Expr getType() {
        return type;
    }

    public List<Expr> getTarget() {
        return target;
    }

    public List<Expr> getValue() {
        return value;
    }
}
