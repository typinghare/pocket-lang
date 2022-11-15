package pocket.pvm;

import pocket.ast.AbstractSyntaxTree;
import pocket.ast.expr.Expr;
import pocket.ast.expr.FnExpr;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.pvm.lang.type.PocketFn;
import pocket.pvm.lang.type.PocketObject;

import java.util.List;

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
    private Scope curScope;

    public PocketVirtualMachine(AbstractSyntaxTree abstractSyntaxTree) {
        this.abstractSyntaxTree = abstractSyntaxTree;
        curScope = rootScope = new Scope(null);
    }

    /**
     * Runs the abstract syntax tree.
     */
    public void run() {
        final Stmt rootStmt = abstractSyntaxTree.getRoot();

        if (rootStmt instanceof ExprStmt) {
            final Expr expr = ((ExprStmt) rootStmt).getExpr();
            if (expr instanceof FnExpr) {
                PocketFn rootFn = (PocketFn) evaluator.evaluate(expr);
                final PocketObject result = rootFn.invoke(List.of());
            }
        } else {
            executor.execute(rootStmt);
        }
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

    /**
     * Creates a new scope linked to the current scope.
     * @return the scope created
     */
    public Scope newScope() {
        final Scope scope = new Scope(curScope);

        curScope = scope;

        return scope;
    }
}
