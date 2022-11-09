package pocket.parser;

import org.junit.Test;
import pocket.ast.Ast;
import pocket.ast.expr.*;
import pocket.ast.operator.BinaryOp;
import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.type.IntType;
import pocket.ast.type.NullType;

import java.util.ArrayList;
import java.util.List;

public class AstTest {
    /**
     * Prints the sample AST.
     */
    @Test
    public void printAST() {
        // print the ast (will generate an HTML file and open it on the default browser)
        getAst().print();
    }

    /**
     * Returns a sample AST.
     */
    public static Ast getAst() {
        /*
        {
            Int a = 2 b = 3, c = 4, d;
            d = a + b * c;
            Console.print(d);
        }
         */

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

        final BlockFnExpr outermostBlockFnExpr = new BlockFnExpr(
                null, List.of(assignStmt1, assignStmt2, exprStmt), null
        );

        final ExprStmt outermostStmt = new ExprStmt(outermostBlockFnExpr);

        // create an ast
        return new Ast(outermostStmt);
    }
}
