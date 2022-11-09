package pocket.ast;

import pocket.ast.expr.*;
import pocket.ast.stmt.AssignStmt;
import pocket.ast.stmt.ExprStmt;
import pocket.ast.stmt.Stmt;
import pocket.ast.type.NullType;
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

    /**
     * Returns the root statement.
     * @return the root statement
     */
    public Stmt getRootStmt() {
        return root;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public void print() {
        final LambdaWrapper<PropertyFetcher<Node>> propertyFetcher = new LambdaWrapper<>();

        final Function<Expr, Object> exprProcessor = (final Expr expr) -> {
            if (expr instanceof IdExpr) {
                return String.format("Id(\\\"%s\\\")", ((IdExpr) expr).getLexeme());
            } else if (expr instanceof TypeExpr) {
                final Type type = ((TypeExpr) expr).getType();
                if (type instanceof NullType) {
                    return "NullType()";
                } else {
                    return String.format(
                            "%s(%s)",
                            type.getClass().getSimpleName(),
                            type.getLiteral()
                    );
                }
            } else {
                return propertyFetcher.lambda.fetch(expr);
            }
        };

        propertyFetcher.lambda = (node) -> {
            if (node == null) {
                return null;
            }

            final HashMap<String, Object> propertyMap = new HashMap<>();
            propertyMap.put(TreePrinter.NAME, node.getClass().getSimpleName());

            if (node instanceof AttrExpr) {
                Expr targetExpr = ((AttrExpr) node).getTarget();
                IdExpr attrExpr = ((AttrExpr) node).getAttr();

                propertyMap.put("value", exprProcessor.apply(targetExpr));
                propertyMap.put("attr", exprProcessor.apply(attrExpr));
            }

            if (node instanceof BlockFnExpr) {
                List<Stmt> stmtList = ((BlockFnExpr) node).getStmtList();
                List<Object> stmtListEx = new ArrayList<>();
                for (var stmt : stmtList)
                    stmtListEx.add(propertyFetcher.lambda.fetch(stmt));
                propertyMap.put("stmtList", stmtListEx);
            }

            if (node instanceof CallExpr) {
                final Expr targetExpr = ((CallExpr) node).getTarget();
                final List<Object> exprList = new ArrayList<>();

                for (Expr argument : ((CallExpr) node).getArgList())
                    exprList.add(exprProcessor.apply(argument));

                propertyMap.put("target", exprProcessor.apply(targetExpr));
                propertyMap.put("argumentList", exprList);
            }

            if (node instanceof AssignStmt) {
                final Expr type = ((AssignStmt) node).getType();

                List<Object> targetListEx = new ArrayList<>();
                List<Object> valueListEx = new ArrayList<>();
                for (Expr target : ((AssignStmt) node).getTargetList())
                    targetListEx.add(exprProcessor.apply(target));
                for (Expr value : ((AssignStmt) node).getValueList()) {
                    valueListEx.add(exprProcessor.apply(value));
                }

                propertyMap.put("type", exprProcessor.apply(type));
                propertyMap.put("targetList", targetListEx);
                propertyMap.put("valueList", valueListEx);
            }

            if (node instanceof ExprStmt) {
                final Expr expr = ((ExprStmt) node).getExpr();
                propertyMap.put("expr", exprProcessor.apply(expr));
            }

            if (node instanceof BinaryExpr) {
                propertyMap.put("operator", ((BinaryExpr) node).getOperator().toString());
                propertyMap.put("left", exprProcessor.apply(((BinaryExpr) node).getLeft()));
                propertyMap.put("right", exprProcessor.apply(((BinaryExpr) node).getRight()));
            }

            return propertyMap;
        };

        new TreePrinter<>("AST", propertyFetcher).print(root);
    }
}
