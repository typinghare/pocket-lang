package pocket.ast.stmt;

import pocket.ast.expr.FnExpr;

/**
 * @author James Chan
 * @example loop { a = a + 1 }  // loop an anonymous block function
 * @example fn = { a = a + 1}; loop fn; //
 */
public class LoopStmt extends Stmt {
    FnExpr anonymousFunctionExpression;

    Id functionIdentifier;
}
