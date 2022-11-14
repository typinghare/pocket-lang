package pocket.ast.stmt;

import pocket.ast.expr.Expr;

import java.util.List;

/**
 * Assignment statement.
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
