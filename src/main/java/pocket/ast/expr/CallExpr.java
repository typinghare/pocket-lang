package pocket.ast.expr;

import java.util.List;

/**
 * @author James Chan
 */
public class CallExpr extends Expr {
    private final Expr target;

    private final List<Expr> argList;

    public CallExpr(Expr target, List<Expr> argList) {
        this.target = target;
        this.argList = argList;
    }

    public Expr getTarget() {
        return target;
    }

    public List<Expr> getArgList() {
        return argList;
    }
}
