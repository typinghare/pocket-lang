// Generated from java-escape by ANTLR 4.11.1

package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link HelloParser#prog}.
     * @param ctx the parse tree
     */
    void enterProg(HelloParser.ProgContext ctx);

    /**
     * Exit a parse tree produced by {@link HelloParser#prog}.
     * @param ctx the parse tree
     */
    void exitProg(HelloParser.ProgContext ctx);

    /**
     * Enter a parse tree produced by {@link HelloParser#decl}.
     * @param ctx the parse tree
     */
    void enterDecl(HelloParser.DeclContext ctx);

    /**
     * Exit a parse tree produced by {@link HelloParser#decl}.
     * @param ctx the parse tree
     */
    void exitDecl(HelloParser.DeclContext ctx);

    /**
     * Enter a parse tree produced by {@link HelloParser}.
     * @param ctx the parse tree
     */
    void enterExpr(HelloParser.ExprContext ctx);

    /**
     * Exit a parse tree produced by {@link HelloParser}.
     * @param ctx the parse tree
     */
    void exitExpr(HelloParser.ExprContext ctx);
}