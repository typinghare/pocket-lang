package pocket.parser;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
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
        Lexer lexer = new Lexer(tokenTypeList);

        lexer.parse("if() else ()", "statement.poke") ;
        lexer.printTokenList("statement.poke");

        lexer.parse("num = 1999 - 3 * 12 / 9", "math.poke");
        lexer.printTokenList("math.poke");

        //
    }
}
