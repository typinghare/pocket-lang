package pocket.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * A facade class that assembles and builds a parser.
 * @author James Chan
 */
public class ParserBuilder {
    private static final Parser parser;

    static {
        List<TokenType> tokenTypeList = new ArrayList<>();

        tokenTypeList.add(StringTokenType.Plus);
        tokenTypeList.add(StringTokenType.Minus);
        tokenTypeList.add(StringTokenType.Star);
        tokenTypeList.add(StringTokenType.Slash);
        tokenTypeList.add(StringTokenType.Equal);
        tokenTypeList.add(StringTokenType.LeftParentheses);
        tokenTypeList.add(StringTokenType.RightParentheses);
        tokenTypeList.add(StringTokenType.If);
        tokenTypeList.add(StringTokenType.Else);
        tokenTypeList.add(PatternTokenType.Int);
        tokenTypeList.add(PatternTokenType.Id);

        parser = new Parser(new Lexer(tokenTypeList), NonTerminal.Stmt);
    }

    /**
     * Returns an assembled parser.
     * @return an assembled parser
     */
    public static Parser parser() {
        return parser;
    }
}
