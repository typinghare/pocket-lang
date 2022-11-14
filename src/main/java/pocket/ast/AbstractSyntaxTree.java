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

/**
 * @param root The root statement.
 */
public record AbstractSyntaxTree(Stmt root) {
    public static abstract class Node {
    }

    /**
     * Returns the root of this abstract syntax tree.
     * @return the root of this abstract syntax tree
     */
    public Stmt getRoot() {
        return root;
    }

    /**
     * Prints this abstract syntax tree.
     * @see TreePrinter
     */
    public void print() {
        final LambdaWrapper<PropertyFetcher<Node>> propertyFetcher = new LambdaWrapper<>();

        final Function<Expr, Object> exprProcessor = (final Expr expr) -> {
            if (expr instanceof IdExpr) {
                // examples: Id("a"), Id("result")
                return String.format("Id(\\\"%s\\\")", ((IdExpr) expr).getValue());
            } else if (expr instanceof TypeExpr) {
                final Type type = ((TypeExpr) expr).getType();
                return type instanceof NullType ?
                        "NullType()" :
                        String.format("%s(%s)", type.getClass().getSimpleName(), type.getLiteral());
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
                propertyMap.put("value", exprProcessor.apply(((AttrExpr) node).getTarget()));
                propertyMap.put("attr", exprProcessor.apply(((AttrExpr) node).getAttr()));
            } else if (node instanceof BinaryExpr) {
                propertyMap.put("operator", ((BinaryExpr) node).getOperator().toString());
                propertyMap.put("left", exprProcessor.apply(((BinaryExpr) node).getLeft()));
                propertyMap.put("right", exprProcessor.apply(((BinaryExpr) node).getRight()));
            } else if (node instanceof CallExpr) {
                final List<Object> exprList = new ArrayList<>();
                for (final Expr argument : ((CallExpr) node).getArgList())
                    exprList.add(exprProcessor.apply(argument));
                propertyMap.put("target", exprProcessor.apply(((CallExpr) node).getTarget()));
                propertyMap.put("argumentList", exprList);
            } else if (node instanceof FnExpr) {
                final List<Object> stmtListEx = new ArrayList<>();
                for (final Stmt stmt : ((FnExpr) node).getStmtList())
                    stmtListEx.add(propertyFetcher.lambda.fetch(stmt));
                propertyMap.put("stmtList", stmtListEx);
            } else if (node instanceof AssignStmt) {
                final List<Object> targetListEx = new ArrayList<>();
                final List<Object> valueListEx = new ArrayList<>();
                for (Expr target : ((AssignStmt) node).getTargetList())
                    targetListEx.add(exprProcessor.apply(target));
                for (Expr value : ((AssignStmt) node).getValueList())
                    valueListEx.add(exprProcessor.apply(value));
                propertyMap.put("type", exprProcessor.apply(((AssignStmt) node).getType()));
                propertyMap.put("targetList", targetListEx);
                propertyMap.put("valueList", valueListEx);
            } else if (node instanceof ExprStmt) {
                propertyMap.put("expr", exprProcessor.apply(((ExprStmt) node).getExpr()));
            }

            return propertyMap;
        };

        new TreePrinter<>("Abstract Syntax Tree", propertyFetcher).print(root);
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
