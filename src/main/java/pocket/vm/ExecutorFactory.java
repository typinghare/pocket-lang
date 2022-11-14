package pocket.vm;

import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.vm.executor.AssignStmtExecutor;
import pocket.vm.executor.Executor;
import pocket.vm.executor.ExprStmtExecutor;

import java.util.HashMap;
import java.util.Map;

public class ExecutorFactory {
    private final Map<Class<? extends Stmt>, Executor> map = new HashMap<>();

    public ExecutorFactory() {
        // register executor here
        map.put(AssignStmt.class, new AssignStmtExecutor());
        map.put(ExprStmt.class, new ExprStmtExecutor());
    }

    /**
     * Returns a proper evaluator.
     */
    public Executor getExecutor(Stmt stmt) {
        return map.get(stmt.getClass());
    }
}
