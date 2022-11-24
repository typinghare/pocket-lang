package pocket.parser;

import org.junit.Test;
import pocket.ast.AbstractSyntaxTree;
import pocket.ast.expr.*;
import pocket.ast.op.BinaryOp;
import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.ast.type.IntType;
import pocket.ast.type.NullType;
import pocket.ast.type.StrType;
import pocket.pvm.PocketVirtualMachine;

import java.util.ArrayList;
import java.util.List;

public class PocketVirtualMachineTest {
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
        // { a = 5 + 10 * 2; }
        final Expr expr5 = new TypeExpr(new IntType("5"));
        final Expr expr10 = new TypeExpr(new IntType("10"));
        final Expr expr2 = new TypeExpr(new IntType("2"));

        final Expr expr = new BinaryExpr(BinaryOp.Multiply, expr10, expr2);
        final Expr exprWhole = new BinaryExpr(BinaryOp.Plus, expr5, expr);
        final Stmt assignStmt = new AssignStmt(null, List.of(new IdExpr("a")), List.of(exprWhole));

        final FnExpr fnExpr = new FnExpr(null, List.of(assignStmt), null);
        final ExprStmt exprStmt = new ExprStmt(fnExpr);
        final AbstractSyntaxTree abstractSyntaxTree = new AbstractSyntaxTree(exprStmt);

        // abstractSyntaxTree.print();

        new PocketVirtualMachine(abstractSyntaxTree).run();
    }

    @Test
    public void builtInFnTest() {
        // { Str name = "Andrew"; Int len = name.length(); }
        // comment: <len> should be <5>

        // name = "Andrew";
        final TypeExpr type = new TypeExpr(new StrType("Andrew"));
        final Stmt assignStmt1 = new AssignStmt(new IdExpr("Str"), List.of(new IdExpr("name")), List.of(type));

        // len = name.length();
        final AttrExpr attrExpr = new AttrExpr(new IdExpr("name"), new IdExpr("length"));
        final CallExpr callExpr = new CallExpr(attrExpr, List.of());
        final Stmt assignStmt2 = new AssignStmt(new IdExpr("Int"), List.of(new IdExpr("len")), List.of(callExpr));

        final FnExpr fnExpr = new FnExpr(null, List.of(assignStmt1, assignStmt2), null);
        final ExprStmt exprStmt = new ExprStmt(fnExpr);
        final AbstractSyntaxTree abstractSyntaxTree = new AbstractSyntaxTree(exprStmt);

        // abstractSyntaxTree.print();

        new PocketVirtualMachine(abstractSyntaxTree).run();
    }

    @Test
    public void consolePrintTest() {
        // {
        //      Int a = 2 b = 3, c = 4, d;
        //      d = a + b * c;
        //      Console.print(d);
        // }

        // Int a = 2 b = 3, c = 4, d;
        final TypeExpr aType = new TypeExpr(new IntType("2"));
        final TypeExpr bType = new TypeExpr(new IntType("3"));
        final TypeExpr cType = new TypeExpr(new IntType("4"));
        final TypeExpr dType = new TypeExpr(new NullType());
        final List<Expr> targetList =
            new ArrayList<>(List.of(new IdExpr("a"), new IdExpr("b"), new IdExpr("c"), new IdExpr("d")));
        final List<Expr> typeList = new ArrayList<>(List.of(aType, bType, cType, dType));

        final AssignStmt assignStmt1 = new AssignStmt(
            new IdExpr("Int"), // type of target variables
            targetList, typeList
        );

        // d = a + b * c;
        final BinaryExpr binaryExpr1 = new BinaryExpr(BinaryOp.Multiply, new IdExpr("b"), new IdExpr("c"));
        final BinaryExpr binaryExpr2 = new BinaryExpr(BinaryOp.Plus, new IdExpr("a"), binaryExpr1);
        final AssignStmt assignStmt2 = new AssignStmt(
            null, List.of(new IdExpr("d")), List.of(binaryExpr2)
        );

        // Console.print(d);
        final IdExpr consoleIdExpr = new IdExpr("Console");
        final AttrExpr attrExpr = new AttrExpr(consoleIdExpr, new IdExpr("print"));
        final CallExpr callExpr = new CallExpr(attrExpr, List.of(new IdExpr("d")));
        final ExprStmt exprStmt = new ExprStmt(callExpr);

        final FnExpr outermostBlockFnExpr = new FnExpr(null, List.of(assignStmt1, assignStmt2, exprStmt), null);
        final ExprStmt outermostStmt = new ExprStmt(outermostBlockFnExpr);
        final AbstractSyntaxTree abstractSyntaxTree = new AbstractSyntaxTree(outermostStmt);

        // abstractSyntaxTree.print();

        new PocketVirtualMachine(abstractSyntaxTree).run();
    }
}
