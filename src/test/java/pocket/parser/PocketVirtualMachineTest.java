package pocket.parser;

import org.junit.Test;
import pocket.ast.AbstractSyntaxTree;
import pocket.ast.expr.*;
import pocket.ast.op.BinaryOp;
import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.ast.type.IntType;
import pocket.ast.type.StrType;
import pocket.pvm.PocketVirtualMachine;

import java.util.List;

public class PocketVirtualMachineTest {
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

        // abstractSyntaxTree.print();

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

        // abstractSyntaxTree.print();

        // run it
        // check the symbol table
        new PocketVirtualMachine(abstractSyntaxTree).run();
    }

    @Test
    public void blockFnTest() {
        // { a = 5 + 10; }
        final Expr leftExpr = new TypeExpr(new IntType("5"));
        final Expr rightExpr = new TypeExpr(new IntType("10"));
        final Expr expr = new BinaryExpr(BinaryOp.Plus, leftExpr, rightExpr);
        final Stmt assignStmt = new AssignStmt(null, List.of(new IdExpr("a")), List.of(expr));

        final FnExpr fnExpr = new FnExpr(null, List.of(assignStmt), null);
        final ExprStmt exprStmt = new ExprStmt(fnExpr);
        final AbstractSyntaxTree abstractSyntaxTree = new AbstractSyntaxTree(exprStmt);

        // abstractSyntaxTree.print();

        new PocketVirtualMachine(abstractSyntaxTree).run();
    }

    @Test
    public void builtInFnTest() {
        // { name = "James"; len = name.length(); }
        // <len> should be <5>

        // name = "James";
        final TypeExpr type = new TypeExpr(new StrType("James"));
        final Stmt assignStmt1 = new AssignStmt(null, List.of(new IdExpr("name")), List.of(type));

        // len = name.length();
        final AttrExpr attrExpr = new AttrExpr(new IdExpr("name"), new IdExpr("length"));
        final CallExpr callExpr = new CallExpr(attrExpr, List.of());
        final Stmt assignStmt2 = new AssignStmt(null, List.of(new IdExpr("len")), List.of(callExpr));

        final FnExpr fnExpr = new FnExpr(null, List.of(assignStmt1, assignStmt2), null);
        final ExprStmt exprStmt = new ExprStmt(fnExpr);
        final AbstractSyntaxTree abstractSyntaxTree = new AbstractSyntaxTree(exprStmt);

        abstractSyntaxTree.print();

        // new PocketVirtualMachine(abstractSyntaxTree).run();
    }
}
