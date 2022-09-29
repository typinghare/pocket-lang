package pocket.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    /**
     * The lexer that creates this tokenizer.
     */
    final Lexer lexer;

    /**
     * Creates a tokenizer.
     * @param lexer the lexer that creates this tokenizer.
     */
    Tokenizer(Lexer lexer) {
        this.lexer = lexer;
    }

    /**
     * Breaks a string into individual tokens.
     * @return a ordered list of tokens
     */
    List<LineToken> tokenize(String string) throws RuntimeException {
        final List<LineToken> tokenList = new ArrayList<>();
        final int length = string.length();
        final Pattern whitespacePattern = Pattern.compile("\\s+");
        int curColumn = 1;
        String str = string;

        while (curColumn <= length) {
            // clear white spaces
            Matcher whitespaceMatcher = whitespacePattern.matcher(str);
            if (whitespaceMatcher.find() && whitespaceMatcher.start() == 0) {
                int whitespaceLength = whitespaceMatcher.end();
                str = str.substring(whitespaceLength);
                curColumn += whitespaceLength;
            }

            // try to match token types one by one from the start of `str`
            boolean matched = false;
            for (TokenType tokenType : lexer.tokenTypeList) {
                int lexemeLength = 0;
                if (tokenType instanceof StringTokenType) {
                    String pattern = ((StringTokenType) tokenType).getPattern();
                    if (!str.startsWith(pattern)) continue;
                    lexemeLength = pattern.length();
                    tokenList.add(new LineToken(tokenType, curColumn));
                } else if (tokenType instanceof PatternTokenType) {
                    Matcher matcher = ((PatternTokenType) tokenType).getPattern().matcher(str);
                    if (!matcher.lookingAt()) continue;
                    lexemeLength = matcher.end();
                    String lexeme = str.substring(0, lexemeLength);
                    tokenList.add(new LineToken(tokenType, lexeme, curColumn));
                }
                str = str.substring(lexemeLength);
                curColumn += lexemeLength;
                matched = true;
                break;
            }

            // if match has not done, raise an exception
            if (!matched) {
                throw new LexicalAnalysisException(curColumn);
            }
//            assert matched : new LexicalAnalysisException(curColumn);
        }

        return tokenList;
    }
}
