package pocket.vm;

import pocket.ast.Ast;
import pocket.ast.expr.AttrExpr;
import pocket.ast.expr.BinaryExpr;
import pocket.ast.expr.BlockFnExpr;
import pocket.ast.expr.Expr;
import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.common.NotNull;
import pocket.vm.type.PocketFn;
import pocket.vm.type.PocketNull;
import pocket.vm.type.PocketObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Pocket virtual machine.
 */
public class Pvm {
    /**
     * The abstract syntax tree to execute
     */
    private final Ast ast;

    /**
     * The root scope.
     */
    private final Scope rootScope;

    private Scope curScope;

    /**
     * Creates a Pocket virtual machine.
     * @param ast abstract syntax tree to execute.
     */
    public Pvm(Ast ast) {
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
        if (stmt instanceof ExprStmt) {
            eval(((ExprStmt) stmt).getExpr());
        } else if (stmt instanceof AssignStmt) {
            final Expr type = ((AssignStmt) stmt).getType();
            final List<Expr> targetList = ((AssignStmt) stmt).getTargetList();
            final List<Expr> valueList = ((AssignStmt) stmt).getValueList();

            // TODO: I haven't designed the class system, therefore, only built-in type is accepted.
            // TODO: And also, the target should only be an AttrExpr
            final List<String> nameList = new ArrayList<>();

            for (final Expr target : targetList) {
                if (target instanceof AttrExpr) {
                    nameList.add(((AttrExpr) target).getAttr().getLexeme());
                }
            }

            final Iterator<String> nameIterator = nameList.iterator();

            for (final Expr value : valueList) {
                final PocketObject pocketObject = eval(value);
                final Symbol symbol = new Symbol(pocketObject);

                if (nameIterator.hasNext()) {
                    curScope.putSymbol(nameIterator.next(), symbol);
                }
            }
        }
    }

    /**
     * Evaluates an expression.
     * @param expr expression to evaluate
     * @return a pocket object
     */
    protected @NotNull PocketObject eval(Expr expr) {
        if (expr instanceof AttrExpr) {
            return PocketNull.NULL;
        } else if (expr instanceof BinaryExpr) {
            return PocketNull.NULL;
        } else if (expr instanceof BlockFnExpr) {
            return new PocketFn(expr);
        }

        return PocketNull.NULL;
    }
}
