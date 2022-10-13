package pocket.parser;

import org.junit.Test;
import org.w3c.dom.Attr;
import pocket.ast.Ast;
import pocket.ast.expr.*;
import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.type.IntType;

import java.util.Arrays;
import java.util.List;

public class AstTestCase {
    @Test
    public void helloWord() {
        System.out.println("Hello World!");
    }

    /**
     * @example { Int a = 1; Console.print(a); }
     */
    @Test
    public void constructAST() {
        final IdExpr aIdExpr1 = new IdExpr("a");
        final TypeExpr typeExpr = new TypeExpr(new IntType("1"));
        final AssignStmt assignStmt = new AssignStmt(new IdExpr("Int"), List.of(aIdExpr1), List.of(typeExpr));

        // Console.print(a);
        final IdExpr consoleIdExpr = new IdExpr("Console");
        final AttrExpr attrExpr = new AttrExpr(consoleIdExpr, "print");   // Console.print
        final IdExpr aIdExpr2 = new IdExpr("a"); // a
        final CallExpr callExpr = new CallExpr(attrExpr, List.of(aIdExpr2));
        final ExprStmt exprStmt = new ExprStmt(callExpr);

        final BlockFnExpr outermostBlockFnExpr = new BlockFnExpr(List.of(assignStmt, exprStmt));
        final ExprStmt outermostStmt = new ExprStmt(outermostBlockFnExpr);

        // create ast
        final Ast ast = new Ast(outermostStmt);

        // print ast
        System.out.println(ast);
    }
}
