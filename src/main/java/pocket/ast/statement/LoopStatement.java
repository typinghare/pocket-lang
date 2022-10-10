package pocket.ast.statement;

import pocket.ast.Identifier;
import pocket.ast.expression.AnonymousFunctionExpression;

/**
 * @author James Chan
 * @example loop { a = a + 1 }  // loop an anonymous block function
 * @example fn = { a = a + 1}; loop fn; //
 */
public class LoopStatement extends Statement {
    AnonymousFunctionExpression anonymousFunctionExpression;

    Identifier functionIdentifier;
}
