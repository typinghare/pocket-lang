package pocket.ast;

import pocket.ast.expr.*;
import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.IfStmt;
import pocket.ast.stmt.Stmt;
import pocket.ast.type.Type;
import twig.LambdaWrapper;
import twig.PropertyFetcher;
import twig.TreePrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class Ast {
    private final Stmt root;

    public Ast(Stmt root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public void print() {
        LambdaWrapper<PropertyFetcher<Node>> propertyFetcher = new LambdaWrapper<>();

        final Function<Expr, Object> exprProcessor = (Expr expr) -> {
            if (expr instanceof IdExpr) {
                return String.format("Id(%s)", ((IdExpr) expr).getLexeme());
            } else if (expr instanceof TypeExpr) {
                return String.format("Type(%s)", ((TypeExpr) expr).getType().getLexeme());
            } else {
                return propertyFetcher.lambda.fetch(expr);
            }
        };

        propertyFetcher.lambda = (node) -> {
            HashMap<String, Object> propertyMap = new HashMap<>();
            propertyMap.put(TreePrinter.NAME, node.getClass().getSimpleName());

            if (node instanceof AttrExpr) {
                Expr expr = ((AttrExpr) node).getValue();
                propertyMap.put("value", exprProcessor.apply(expr));
                propertyMap.put("attr", ((AttrExpr) node).getAttr());
            }

            if (node instanceof BlockFnExpr) {
                List<Stmt> stmtList = ((BlockFnExpr) node).getStmtList();
                List<Object> stmtListEx = new ArrayList<>();
                for (var stmt : stmtList)
                    stmtListEx.add(propertyFetcher.lambda.fetch(stmt));
                propertyMap.put("stmtList", stmtListEx);
            }

            if (node instanceof CallExpr) {
                List<Expr> argumentList = ((CallExpr) node).getArgumentList();
                List<Object> exprList = new ArrayList<>();
                for (Expr argument : argumentList)
                    exprList.add(exprProcessor.apply(argument));
                propertyMap.put("ExprList", exprList);
            }

            if (node instanceof AssignStmt) {
                Expr type = ((AssignStmt) node).getType();
                List<Expr> targetList = ((AssignStmt) node).getTargetList();
                List<Expr> valueList = ((AssignStmt) node).getValueList();

                List<Object> targetListEx = new ArrayList<>();
                List<Object> valueListEx = new ArrayList<>();
                for (Expr target : targetList)
                    targetListEx.add(exprProcessor.apply(target));
                for (Expr value : valueList)
                    valueListEx.add(exprProcessor.apply(value));

                propertyMap.put("type", exprProcessor.apply(type));
                propertyMap.put("targetList", targetListEx);
                propertyMap.put("valueList", valueListEx);
            }

            if (node instanceof ExprStmt) {
                Expr expr = ((ExprStmt) node).getExpr();
                propertyMap.put("expr", exprProcessor.apply(expr));
            }

            return propertyMap;
        };

        TreePrinter<Node> treePrinter = new TreePrinter<>("AST", propertyFetcher);
        treePrinter.print(root);
    }
}
