package pocket.vm;

import pocket.ast.Ast;
import pocket.ast.expr.Expr;
import pocket.ast.stmt.Stmt;
import pocket.common.NotNull;
import pocket.vm.evaluator.Evaluator;
import pocket.vm.type.PocketObject;

/**
 * Pocket virtual machine.
 */
public class Pvm {
    /**
     * The abstract syntax tree to execute
     */
    private Ast ast;

    /**
     * The root scope.
     */
    private Scope rootScope;

    /**
     * The current scope.
     */
    private Scope curScope;

    private final EvaluatorFactory evaluatorFactory = new EvaluatorFactory();

    private final ExecutorFactory executorFactory = new ExecutorFactory();

    /**
     * Creates a Pocket virtual machine.
     */
    private Pvm() {
    }

    public void putSymbol(String name, Symbol symbol) {
        curScope.putSymbol(name, symbol);
        System.out.println("[assign] " + name + " = " + symbol);
    }

    private static final class InstanceHolder {
        private static final Pvm instance = new Pvm();
    }

    public static Pvm instance() {
        return InstanceHolder.instance;
    }

    /**
     * Initialize the PVM.
     * @param ast abstract syntax tree to bind
     */
    public void init(Ast ast) {
        this.ast = ast;
        curScope = rootScope = new Scope(null);
    }

    /**
     * Runs the ast directly.
     */
    public void run() {
        final Stmt rootStmt = ast.getRootStmt();

        executeStmt(rootStmt);
    }

    /**
     * Executes the statement.
     * @param stmt statement to execute
     */
    protected void executeStmt(Stmt stmt) {
        executorFactory.getExecutor(stmt).execute(stmt);
    }

    /**
     * Evaluates an expression.
     * @param expr expression to evaluate
     * @return a pocket object
     */
    public @NotNull PocketObject eval(Expr expr) {
        final Evaluator evaluator = evaluatorFactory.getEvaluator(expr);
        final PocketObject pocketObject = evaluator.eval(expr);

        System.out.println(pocketObject);

        return pocketObject;
    }
}
