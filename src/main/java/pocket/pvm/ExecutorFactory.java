package pocket.pvm;

import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.pvm.executor.AssignStmtExecutor;
import pocket.pvm.executor.ExprStmtExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * Executor factory.
 */
public class ExecutorFactory {
    private final Map<Class<? extends Stmt>, Executor> stmtClassEvaluatorMap = new HashMap<>();

    public ExecutorFactory(PocketVirtualMachine pocketVirtualMachine) {
        // register executors here
        stmtClassEvaluatorMap.put(AssignStmt.class, new AssignStmtExecutor(pocketVirtualMachine));
        stmtClassEvaluatorMap.put(ExprStmt.class, new ExprStmtExecutor(pocketVirtualMachine));
    }

    /**
     * Returns an executor by a specified statement class.
     * @return the evaluator corresponding to the specified statement class
     */
    public Executor getExecutor(Class<? extends Stmt> stmtClass) {
        return stmtClassEvaluatorMap.get(stmtClass);
    }
}
