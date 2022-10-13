package pocket.ast.expr;

import java.util.List;

/**
 * @author James Chan
 */
public class CallExpr extends Expr {
    private final Expr fn;

    private final List<Expr> argumentList;

    public CallExpr(Expr fn, List<Expr> argumentList) {
        this.fn = fn;
        this.argumentList = argumentList;
    }

    public List<Expr> getArgumentList() {
        return argumentList;
    }

    public Expr getFn() {
        return fn;
    }
}
