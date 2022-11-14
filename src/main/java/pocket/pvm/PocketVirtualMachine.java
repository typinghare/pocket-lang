package pocket.pvm;

import pocket.ast.AbstractSyntaxTree;
import pocket.ast.stmt.Stmt;

/**
 * Pocket virtual machine.
 */
public class PocketVirtualMachine {
    private final Evaluator evaluator = new Evaluator(this);

    private final Executor executor = new Executor(this);

    private final EvaluatorFactory evaluatorFactory = new EvaluatorFactory(this);

    private final ExecutorFactory executorFactory = new ExecutorFactory(this);

    private final AbstractSyntaxTree abstractSyntaxTree;

    /**
     * The root scope.
     */
    private final Scope rootScope;

    /**
     * The current scope.
     */
    private final Scope curScope;

    public PocketVirtualMachine(AbstractSyntaxTree abstractSyntaxTree) {
        this.abstractSyntaxTree = abstractSyntaxTree;
        curScope = rootScope = new Scope(null);
    }

    /**
     * Runs the abstract syntax tree.
     */
    public void run() {
        final Stmt exprStmt = abstractSyntaxTree.getRoot();
        executor.execute(exprStmt);
    }

    /**
     * Puts a symbol to the symbol table of the current scope.
     * @param name   name of the symbol
     * @param symbol symbol to record
     */
    public void putSymbol(String name, Symbol symbol) {
        curScope.putSymbol(name, symbol);
        System.out.println("[assign] " + name + " = " + symbol);
    }

    public Evaluator getEvaluator() {
        return evaluator;
    }

    public Executor getExecutor() {
        return executor;
    }

    public EvaluatorFactory getEvaluatorFactory() {
        return evaluatorFactory;
    }

    public ExecutorFactory getExecutorFactory() {
        return executorFactory;
    }
}
