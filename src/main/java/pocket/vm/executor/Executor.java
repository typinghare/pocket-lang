package pocket.vm.executor;

import pocket.ast.stmt.Stmt;

public abstract class Executor {
    public abstract void execute(Stmt stmt);
}
