package pocket.ast.stmt;

import pocket.ast.expr.FnExpr;
import pocket.ast.expr.IdExpr;

/**
 * @author James Chan
 * @example loop { a = a + 1 }  // loop an anonymous block function
 * @example fn = { a = a + 1}; loop fn; //
 */
public class LoopStmt extends Stmt {
    FnExpr fnExpr;

    IdExpr fnId;
}
