package pocket.pvm.executor;

import pocket.ast.expr.AttrExpr;
import pocket.ast.expr.Expr;
import pocket.ast.expr.IdExpr;
import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.Stmt;
import pocket.pvm.Executor;
import pocket.pvm.PocketVirtualMachine;
import pocket.pvm.lang.type.*;

import java.util.List;

public class AssignStmtExecutor extends Executor {
    public AssignStmtExecutor(PocketVirtualMachine pocketVirtualMachine) {
        super(pocketVirtualMachine);
    }

    @Override
    public void execute(Stmt stmt) {
        final Expr typeExpr = ((AssignStmt) stmt).getType();
        final List<Expr> targetList = ((AssignStmt) stmt).getTargetList();
        final List<Expr> valueList = ((AssignStmt) stmt).getValueList();

        for (int i = 0; i < targetList.size(); i++) {
            final Expr target = targetList.get(i);

            if (target instanceof IdExpr) {
                final String name = ((IdExpr) target).getValue();
                final Expr value = valueList.get(i);
                PocketObject pocketObject = pocketVirtualMachine.getEvaluator().evaluate(value);

                // type
                final PocketObject type = pocketVirtualMachine.getEvaluator().evaluate(typeExpr);
                assert type instanceof PocketClass || type == null;

                // assign a value if the pocket object is null
                if (pocketObject == null) {
                    pocketObject = getInitialPocketObject((PocketClass) type);
                }

                if (type != null) {
                    assert pocketObject != null;
                    pocketVirtualMachine.getCurScope().putObject(name, pocketObject, (PocketClass) type);
                } else {
                    pocketVirtualMachine.getCurScope().putObject(name, pocketObject);
                }
            } else if (target instanceof AttrExpr) {
                // Not implement
                throw new RuntimeException();
            } else {
                // Not implement
                throw new RuntimeException();
            }
        }
    }

    private PocketObject getInitialPocketObject(PocketClass pocketClass) {
        if (pocketClass == PocketInt.intPocketClass) {
            return new PocketInt(0);
        } else if (pocketClass == PocketFloat.floatPocketClass) {
            return new PocketFloat(0f);
        } else if (pocketClass == PocketBool.boolPocketClass) {
            return new PocketBool(false);
        } else if (pocketClass == PocketStr.strPocketClass) {
            return new PocketStr("");
        } else if (pocketClass == PocketClass.classPocketClass) {
            return PocketObject.VOID;
        } else {
            return PocketObject.VOID;
        }
    }
}
