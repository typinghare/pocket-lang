package pocket.ast.stmt;

import pocket.ast.expr.Expr;

/**
 * @author James Chan
 * @example a = b + 2   // type is omitted; implicit declaration
 * @example Int a = b + 2   // declaration assignment
 */
public class AssignStmt extends Stmt {
    private Expr type;

    private Expr target;

    private Expr value;
}
