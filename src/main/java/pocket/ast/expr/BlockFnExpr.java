package pocket.ast.expr;

import pocket.ast.stmt.Stmt;

import java.util.List;

/**
 * Block function.
 * @author James Chan
 * @example { a = b + 1; }
 * @example { if (a > b) a = b; return a; }     // return statement included
 */
public class BlockFnExpr extends Expr {
    private final List<Stmt> stmtList;

    private final Stmt returnStmt;

    private final Stmt breakStmt;

    private final Stmt continueStmt;

    public BlockFnExpr(List<Stmt> stmtList, Stmt returnStmt, Stmt breakStmt, Stmt continueStmt) {
        this.stmtList = stmtList;
        this.returnStmt = returnStmt;
        this.breakStmt = breakStmt;
        this.continueStmt = continueStmt;
    }

    public BlockFnExpr(List<Stmt> stmtList) {
        this(stmtList, null, null, null);
    }

    public List<Stmt> getStmtList() {
        return stmtList;
    }

    public Stmt getReturnStmt() {
        return returnStmt;
    }

    public Stmt getBreakStmt() {
        return breakStmt;
    }

    public Stmt getContinueStmt() {
        return continueStmt;
    }
}
