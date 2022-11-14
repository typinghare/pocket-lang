package pocket.pvm;

import pocket.ast.stmt.Stmt;

/**
 * Executor.
 */
public class Executor {
    protected final PocketVirtualMachine pocketVirtualMachine;

    public Executor(PocketVirtualMachine pocketVirtualMachine) {
        this.pocketVirtualMachine = pocketVirtualMachine;
    }

    /**
     * Executes a statement.
     * @param stmt statement to execute
     */
    public void execute(Stmt stmt) {
        pocketVirtualMachine.getExecutorFactory().getExecutor(stmt.getClass()).execute(stmt);
    }
}
