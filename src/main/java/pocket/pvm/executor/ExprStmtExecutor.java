package pocket.pvm.executor;

import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.pvm.Executor;
import pocket.pvm.PocketVirtualMachine;

public class ExprStmtExecutor extends Executor {
    public ExprStmtExecutor(PocketVirtualMachine pocketVirtualMachine) {
        super(pocketVirtualMachine);
    }

    @Override
    public void execute(Stmt stmt) {
        assert stmt instanceof ExprStmt;

        pocketVirtualMachine.getEvaluator().evaluate(((ExprStmt) stmt).getExpr());
    }
}
