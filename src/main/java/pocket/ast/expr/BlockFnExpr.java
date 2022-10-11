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
    private List<Stmt> stmtList;

    private Stmt returnStmt;

    private Stmt breakStmt;

    private Stmt continueStmt;
}
