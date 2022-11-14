package pocket.vm.executor;

import pocket.ast.expr.Expr;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.vm.Pvm;

public class ExprStmtExecutor extends Executor {
    @Override
    public void execute(Stmt stmt) {
        assert stmt instanceof ExprStmt;

        final Expr expr = ((ExprStmt) stmt).getExpr();
        Pvm.instance().eval(expr);
    }
}
