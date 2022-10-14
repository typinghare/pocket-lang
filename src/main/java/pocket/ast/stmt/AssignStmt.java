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

    private final List<Expr> targetList;

    private final List<Expr> valueList;

    public AssignStmt(Expr type, List<Expr> targetList, List<Expr> valueList) {
        this.type = type;
        this.targetList = targetList;
        this.valueList = valueList;
    }

    public Expr getType() {
        return type;
    }

    public List<Expr> getTargetList() {
        return targetList;
    }

    public List<Expr> getValueList() {
        return valueList;
    }
}
