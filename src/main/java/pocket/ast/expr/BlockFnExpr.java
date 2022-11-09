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
    private final Expr returnType;

    private final List<Stmt> stmtList;

    private final Stmt returnStmt;

    public BlockFnExpr(Expr returnType, List<Stmt> stmtList, Stmt returnStmt) {
        this.returnType = returnType;
        this.stmtList = stmtList;
        this.returnStmt = returnStmt;
    }

    public Expr getReturnType() {
        return returnType;
    }

    public List<Stmt> getStmtList() {
        return stmtList;
    }

    public Stmt getReturnStmt() {
        return returnStmt;
    }
}
