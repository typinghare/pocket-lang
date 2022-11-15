package pocket.pvm.lang.type;

import pocket.ast.expr.Expr;
import pocket.ast.expr.FnExpr;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.pvm.Executor;
import pocket.pvm.PocketVirtualMachine;
import pocket.pvm.Symbol;
import pocket.pvm.lang.BasicDataType;

import java.util.List;

public class PocketFn extends PocketObject {
    private final FnExpr value;

    private final PocketVirtualMachine pocketVirtualMachine;

    public PocketFn(FnExpr fnExpr, PocketVirtualMachine pocketVirtualMachine) {
        this.value = fnExpr;
        this.pocketVirtualMachine = pocketVirtualMachine;
    }

    /**
     * Invokes this function.
     * @param argumentValueList argument list
     */
    public PocketObject invoke(List<PocketObject> argumentValueList) {
        // creates a new scope
        pocketVirtualMachine.newScope();

        if (!value.isBlockFn()) {
            final List<String> paramNameList = value.getParamNameList();
            final int argumentCount = paramNameList.size();
            assert argumentCount == argumentValueList.size();

            // adds argument symbols to the current scope
            final List<Expr> paramTypeList = value.getParamTypeList();
            for (int i = 0; i < argumentCount; i++) {
                final Symbol symbol = new Symbol(argumentValueList.get(i), BasicDataType.Object);
                pocketVirtualMachine.putSymbol(paramNameList.get(i), symbol);
            }
        }

        runStmt();
        return runReturnStmt();
    }

    private void runStmt() {
        final List<Stmt> stmtList = value.getStmtList();
        final Executor executor = pocketVirtualMachine.getExecutor();

        for (final Stmt stmt : stmtList) {
            executor.execute(stmt);
        }
    }

    public PocketObject runReturnStmt() {
        final ExprStmt returnStmt = value.getReturnStmt();
        if (returnStmt == null) return PocketObject.VOID;

        final Expr expr = returnStmt.getExpr();
        return expr == null ? PocketObject.VOID : pocketVirtualMachine.getEvaluator().evaluate(expr);
    }
}
