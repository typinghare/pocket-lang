package pocket.vm.executor;

import pocket.ast.expr.Expr;
import pocket.ast.expr.IdExpr;
import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.Stmt;
import pocket.vm.Pvm;
import pocket.vm.Symbol;
import pocket.vm.Type;
import pocket.vm.type.*;

import java.util.List;

public class AssignStmtExecutor extends Executor {
    @Override
    public void execute(Stmt stmt) {
        assert stmt instanceof AssignStmt;

        final Expr type = ((AssignStmt) stmt).getType();
        final List<Expr> targetList = ((AssignStmt) stmt).getTargetList();
        final List<Expr> valueList = ((AssignStmt) stmt).getValueList();

        // TODO: I haven't designed the class system, therefore, only built-in type is accepted.
        // TODO: And also, the target should only be an AttrExpr

        for (int i = 0; i < targetList.size(); i++) {
            final Expr target = targetList.get(i);

            if (target instanceof IdExpr) {
                final String name = ((IdExpr) target).getLexeme();
                final Expr value = valueList.get(i);
                final PocketObject pocketObject = Pvm.instance().eval(value);
                final Symbol symbol = new Symbol(pocketObject, getTypeOf(pocketObject));

                Pvm.instance().putSymbol(name, symbol);
            } else {
                // Not implement
                throw new RuntimeException();
            }
        }
    }

    public Type getTypeOf(PocketObject pocketObject) {
        if (pocketObject instanceof PocketInt) {
            return Type.Int;
        } else if (pocketObject instanceof PocketFloat) {
            return Type.Float;
        } else if (pocketObject instanceof PocketBool) {
            return Type.Bool;
        } else if (pocketObject instanceof PocketFn) {
            return Type.Fn;
        } else {
            return null;
        }
    }
}
