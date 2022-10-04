package pocket.parser;

import pocket.parser.exception.ProductionException;

import java.util.*;

/**
 * A top-down parser.
 * @author James Chan
 * @see <a href="https://www.geeksforgeeks.org/parse-tree-in-compiler-design/">...</a>
 */
public class Parser {
    /**
     * The start symbol.
     */
    final NonTerminal startSymbol;

    /**
     * A supporting lexer.
     */
    final Lexer lexer;

    /**
     * Mapping: non-terminal symbol => [...productions]
     */
    final Map<NonTerminal, List<Production>> productionMap = new HashMap<>();

    /**
     * Creates a parser.
     * @param lexer a lexer.
     */
    public Parser(Lexer lexer, NonTerminal startSymbol) {
        this.startSymbol = startSymbol;
        this.lexer = lexer;
    }

    /**
     * Adds a production to this parser.
     * @param nonTerminal  a non-terminal symbol served as the left-hand-side of the production
     * @param notationList a list of notations served as the right-hand-side of the production
     * @return this parser
     */
    Parser addProduction(NonTerminal nonTerminal, List<Notation> notationList) throws ProductionException {
        if (notationList.isEmpty()) {
            throw new ProductionException("The right side of the production is empty.");
        }

        if ((notationList.get(0) instanceof Terminal)) {
            throw new ProductionException("Only right recursions are allowed.");
        }

        Production production = new Production(nonTerminal, notationList);

        if (!productionMap.containsKey(nonTerminal)) {
            productionMap.put(nonTerminal, new ArrayList<>());
        }

        productionMap.get(nonTerminal).add(production);

        return this;
    }

    /**
     * Generates an AST (abstract syntax tree).
     */
    AbstractSyntaxTree parse(String text, String label) throws Exception {
        final List<Token> tokenList = lexer.parse(text, label);
        final TokenProvider tokenProvider = new TokenProvider(tokenList);
        final ParseTree parseTree = generateParseTree(tokenProvider, startSymbol);

        // TODO: implement AST parser

        return new AbstractSyntaxTree();
    }

    /**
     * Generates a parse tree.
     * @param tokenProvider token provider
     * @param leftSide      a specified non-terminal symbol
     * @return a parse tree.
     */
    private ParseTree generateParseTree(TokenProvider tokenProvider, NonTerminal leftSide) throws Exception {
        final ParseTree parseTree = new ParseTree(leftSide);
        final List<Production> productionList = productionMap.get(leftSide);

        boolean isMatched = false;
        for (Production production : productionList) {
            final int matchResult = matchProduction(tokenProvider, production);

            if (-1 == matchResult) continue;
            isMatched = true;

            for (int i = 0; i < matchResult; i++)
                parseTree.add(new ParseTree(tokenProvider.next()));

            int notationListSize = production.notationList.size();
            if (notationListSize > matchResult) {
                List<Notation> notationList = production.notationList;
                for (int i = matchResult; i < notationListSize; i++) {
                    NonTerminal nonTerminal = (NonTerminal) notationList.get(i);
                    ParseTree child = generateParseTree(tokenProvider, nonTerminal);
                    parseTree.add(child);
                }
            }

            break;
        }

        if (!isMatched) {
            throw new Exception("Fail to generate the parse tree.");
        }

        return parseTree;
    }

    /**
     * Test if the token list matches the given production.
     * @param tokenProvider token provider
     * @param production    a specified production
     * @return the index of the first non-terminal symbol if matched, -1 otherwise
     */
    private int matchProduction(TokenProvider tokenProvider, Production production) {
        final List<Notation> notationList = production.notationList;

        for (int i = 0; i < notationList.size(); i++) {
            Notation notation = notationList.get(i);
            if (notation instanceof NonTerminal) return i;
            if (tokenProvider.peek(i).tokenType != notation) return -1;
        }

        return notationList.size();
    }
}
