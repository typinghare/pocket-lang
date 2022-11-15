package pocket.pvm.executor;

import pocket.ast.expr.AttrExpr;
import pocket.ast.expr.Expr;
import pocket.ast.expr.IdExpr;
import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.Stmt;
import pocket.pvm.Executor;
import pocket.pvm.PocketVirtualMachine;
import pocket.pvm.Symbol;
import pocket.pvm.lang.BasicDataType;
import pocket.pvm.lang.type.*;

import java.util.List;

public class AssignStmtExecutor extends Executor {
    public AssignStmtExecutor(PocketVirtualMachine pocketVirtualMachine) {
        super(pocketVirtualMachine);
    }

    @Override
    public void execute(Stmt stmt) {
        final Expr type = ((AssignStmt) stmt).getType();
        final List<Expr> targetList = ((AssignStmt) stmt).getTargetList();
        final List<Expr> valueList = ((AssignStmt) stmt).getValueList();

        // TODO: I haven't designed the class system, therefore, only built-in type is accepted.
        // TODO: And also, the target should only be an AttrExpr

        for (int i = 0; i < targetList.size(); i++) {
            final Expr target = targetList.get(i);

            if (target instanceof IdExpr) {
                final String name = ((IdExpr) target).getValue();
                final Expr value = valueList.get(i);
                final PocketObject pocketObject = pocketVirtualMachine.getEvaluator().evaluate(value);
                final Symbol symbol = new Symbol(pocketObject, getTypeOf(pocketObject));

                pocketVirtualMachine.putSymbol(name, symbol);
            } else if (target instanceof AttrExpr) {
                throw new RuntimeException();
            } else {
                // Not implement
                throw new RuntimeException();
            }
        }
    }

    public BasicDataType getTypeOf(PocketObject pocketObject) {
        if (pocketObject instanceof PocketInt) {
            return BasicDataType.Int;
        } else if (pocketObject instanceof PocketFloat) {
            return BasicDataType.Float;
        } else if (pocketObject instanceof PocketBool) {
            return BasicDataType.Bool;
        } else if (pocketObject instanceof PocketFn) {
            return BasicDataType.Fn;
        } else {
            return null;
        }
    }
}
