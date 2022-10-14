package pocket.ast.stmt;

import pocket.ast.expr.BoolExpr;

import java.util.List;

/**
 * If statement.
 * @author James Chan
 */
public class IfStmt extends Stmt {
    private BoolExpr boolExpr;

    private List<Stmt> stmtList;
}
