package pocket.ast.statement;

import pocket.ast.Identifier;
import pocket.ast.expression.Expression;

/**
 * @author James Chan
 * @example a = b + 2   // type is omitted; implicit declaration
 * @example Int a = b + 2   // declaration assignment
 */
public class AssignStatement extends Statement {
    Identifier type;

    Identifier target;

    Expression value;
}
