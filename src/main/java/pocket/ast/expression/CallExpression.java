package pocket.ast.expression;

import pocket.ast.Identifier;

import java.util.List;

/**
 * @author James Chan
 */
public class CallExpression {
    Identifier functionName;

    List<Expression> argumentList;
}
