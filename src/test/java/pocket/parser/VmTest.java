package pocket.parser;

import org.junit.Test;
import pocket.ast.AbstractSyntaxTree;
import pocket.ast.expr.BinaryExpr;
import pocket.ast.expr.Expr;
import pocket.ast.expr.IdExpr;
import pocket.ast.expr.TypeExpr;
import pocket.ast.op.BinaryOp;
import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.ast.type.IntType;
import pocket.pvm.PocketVirtualMachine;

import java.util.List;

public class VmTest {
    @Test
    public void runAST() {
        final AbstractSyntaxTree abstractSyntaxTree = AbstractSyntaxTreeTest.getAst();

        // run it
        new PocketVirtualMachine(abstractSyntaxTree).run();
    }

    @Test
    public void binaryExprTest() {
        // 5 + 10
        final Expr leftExpr = new TypeExpr(new IntType("5"));
        final Expr rightExpr = new TypeExpr(new IntType("10"));
        final Expr expr = new BinaryExpr(BinaryOp.Plus, leftExpr, rightExpr);
        final AbstractSyntaxTree abstractSyntaxTree = new AbstractSyntaxTree(new ExprStmt(expr));

        // ast.print();

        // run it
        new PocketVirtualMachine(abstractSyntaxTree).run();
    }

    @Test
    public void AssignStmtTest() {
        // a = 5 + 10
        final Expr leftExpr = new TypeExpr(new IntType("5"));
        final Expr rightExpr = new TypeExpr(new IntType("10"));
        final Expr expr = new BinaryExpr(BinaryOp.Plus, leftExpr, rightExpr);
        final Stmt assignStmt = new AssignStmt(null, List.of(new IdExpr("a")), List.of(expr));

        final AbstractSyntaxTree abstractSyntaxTree = new AbstractSyntaxTree(assignStmt);

//        ast.print();

        // run it
        // check the symbol table
        new PocketVirtualMachine(abstractSyntaxTree).run();
    }
}
