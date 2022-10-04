package pocket.parser;

import pocket.parser.exception.LexicalAnalysisException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tokenizer is created by a lexer. The core function `tokenize` breaks a line string into individual line tokens. Line
 * string means the string doesn't contain newline characters.
 * @author James Chan
 * @see LineToken
 */
public class Tokenizer {
    /**
     * The whitespace pattern.
     */
    final static Pattern whitespacePattern = Pattern.compile("\\s*");

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
     * Breaks a string into individual line tokens. How it works: Loop until the given string is empty, this tokenizer
     * will trim the leading empty characters, and try to match token types in the `tokenTypeList` in the lexer class.
     * Once matched, it creates a token with the matched token type and add it to a `tokenList`. Finally, the
     * `tokenList` will be returned.
     * @return an ordered list of tokens
     * @throws LexicalAnalysisException if no token type is being matched during processing
     */
    List<LineToken> tokenize(String string) throws RuntimeException {
        final List<LineToken> tokenList = new ArrayList<>();
        final int length = string.length();
        int curColumn = 1;
        String str = string;

        while (curColumn <= length) {
            // trim whitespaces
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
            if (!matched) throw new LexicalAnalysisException(curColumn);
        }

        return tokenList;
    }
}
