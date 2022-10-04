package pocket.parser;

import java.util.List;

/**
 * Production or (rewrite) rule.
 */
public class Production {
    /**
     * The left side of this production. One non-terminal symbol is allowed.
     */
    final NonTerminal nonTerminal;

    /**
     * The right side of this production.
     */
    final List<Notation> notationList;

    /**
     * Creates a production.
     * @param nonTerminal  a non-terminal symbol
     * @param notationList a notation list
     */
    Production(NonTerminal nonTerminal, List<Notation> notationList) {
        this.nonTerminal = nonTerminal;
        this.notationList = notationList;
    }
}
