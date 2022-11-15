package pocket.ast.expr;

import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;

import java.util.List;

/**
 * Function expression. If paramTypeList and paramNameList are null, this function is seen as a block function.
 */
public class FnExpr extends Expr {
    private final List<Expr> paramTypeList;

    private final List<String> paramNameList;

    private final Expr returnType;

    private final List<Stmt> stmtList;

    private final ExprStmt returnStmt;

    public FnExpr(
            List<Expr> paramTypeList,
            List<String> paramNameList,
            Expr returnType,
            List<Stmt> stmtList,
            ExprStmt returnStmt
    ) {
        this.paramTypeList = paramTypeList;
        this.paramNameList = paramNameList;
        this.returnType = returnType;
        this.stmtList = stmtList;
        this.returnStmt = returnStmt;
    }

    public FnExpr(
            Expr returnType,
            List<Stmt> stmtList,
            ExprStmt returnStmt
    ) {
        this(null, null, returnType, stmtList, returnStmt);
    }

    public List<Expr> getParamTypeList() {
        return paramTypeList;
    }

    public List<String> getParamNameList() {
        return paramNameList;
    }

    public Expr getReturnType() {
        return returnType;
    }

    public List<Stmt> getStmtList() {
        return stmtList;
    }

    public ExprStmt getReturnStmt() {
        return returnStmt;
    }

    public boolean isBlockFn() {
        return paramTypeList == null && paramNameList == null;
    }
}
