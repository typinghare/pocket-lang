package pocket.parser;

import org.junit.Test;
import pocket.ast.Ast;
import pocket.ast.expr.BinaryExpr;
import pocket.ast.expr.Expr;
import pocket.ast.expr.IdExpr;
import pocket.ast.expr.TypeExpr;
import pocket.ast.operator.BinaryOp;
import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.ast.type.IntType;
import pocket.vm.Pvm;

import java.util.List;

public class VmTest {
    @Test
    public void runAST() {
        final Ast ast = AstTest.getAst();

        // run it
        Pvm.instance().init(ast);
        Pvm.instance().run();
    }

    @Test
    public void binaryExprTest() {
        // 5 + 10
        final Expr leftExpr = new TypeExpr(new IntType("5"));
        final Expr rightExpr = new TypeExpr(new IntType("10"));
        final Expr expr = new BinaryExpr(BinaryOp.Plus, leftExpr, rightExpr);
        final Ast ast = new Ast(new ExprStmt(expr));

        // ast.print();

        // run it
        Pvm.instance().init(ast);
        Pvm.instance().run();
    }

    @Test
    public void AssignStmtTest() {
        // a = 5 + 10
        final Expr leftExpr = new TypeExpr(new IntType("5"));
        final Expr rightExpr = new TypeExpr(new IntType("10"));
        final Expr expr = new BinaryExpr(BinaryOp.Plus, leftExpr, rightExpr);
        final Stmt assignStmt = new AssignStmt(null, List.of(new IdExpr("a")), List.of(expr));
        final Ast ast = new Ast(assignStmt);

//        ast.print();

        // run it
        // check the symbol table
        Pvm.instance().init(ast);
        Pvm.instance().run();
    }
}
