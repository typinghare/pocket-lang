package pocket.pvm;

import pocket.ast.AbstractSyntaxTree;
import pocket.ast.expr.Expr;
import pocket.ast.expr.FnExpr;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.pvm.cls.ClassManager;
import pocket.pvm.lang.type.PocketClass;
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

    private final ClassManager classManager = new ClassManager();

    /**
     * The current scope.
     */
    private Scope curScope;

    public PocketVirtualMachine(AbstractSyntaxTree abstractSyntaxTree) {
        this.abstractSyntaxTree = abstractSyntaxTree;
    }

    /**
     * Runs the abstract syntax tree.
     */
    public void run() {
        initializeLang();

        final Stmt rootStmt = abstractSyntaxTree.getRoot();

        if (rootStmt instanceof ExprStmt) {
            final Expr expr = ((ExprStmt) rootStmt).getExpr();
            if (expr instanceof FnExpr) {
                PocketFn rootFn = (PocketFn) evaluator.evaluate(expr);
                final PocketObject result = rootFn.invoke(List.of());

                System.out.println("[Return] " + (result == null ? "" : result.toString()));
            }
        } else {
            executor.execute(rootStmt);
        }
    }

    private void initializeLang() {
        curScope = new Scope(null);
        curScope.putObject("Console", classManager.getPocketClass("Console"), PocketClass.classPocketClass);

        curScope.putObject("Int", classManager.getPocketClass("Int"), PocketClass.classPocketClass);
        curScope.putObject("Float", classManager.getPocketClass("Float"), PocketClass.classPocketClass);
        curScope.putObject("Str", classManager.getPocketClass("Str"), PocketClass.classPocketClass);
        curScope.putObject("Bool", classManager.getPocketClass("Bool"), PocketClass.classPocketClass);
    }

    /**
     * Returns the current scope.
     * @return the current scope
     */
    public Scope getCurScope() {
        return curScope;
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

    /**
     * Returns a pocket class.
     * @param className the name of the class
     */
    public PocketClass getPocketClass(String className) {
        return classManager.getPocketClass(className);
    }
}
