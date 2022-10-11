package pocket.ast.expr;

import java.util.List;

/**
 * Parametric function.
 * @author James Chan
 * @example (Int a, Int b) { if (a > b) return a; else return b; }
 */
public class FnExpr extends BlockFnExpr {
    private List<Expr> parameterStatementList;
}
