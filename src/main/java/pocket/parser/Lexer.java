package pocket.parser;

import pocket.parser.exception.LexicalAnalysisException;

import java.util.*;

/**
 * A lexer.
 * @author James Chan
 */
public class Lexer {
    /**
     * List of token types.
     */
    final List<TokenType> tokenTypeList;

    /**
     * Mapping rule: label => token list
     */
    final Map<String, List<Token>> tokenListMap = new HashMap<>();

    /**
     * Tokenizer.
     */
    final Tokenizer tokenizer = new Tokenizer(this);

    /**
     * Creates a lexer.
     * @param tokenTypeList list of token types.
     */
    Lexer(List<TokenType> tokenTypeList) {
        this.tokenTypeList = tokenTypeList;
    }

    /**
     * Breaks a text into tokens. It first splits the text into lines and uses tokenizer to generate
     * line token list. Then it convert line tokens into tokens, which contain line numbers.
     * @param text  text to be parsed
     * @param label reference of the result token list
     * @return the list of tokens.
     */
    List<Token> parse(String text, String label) {
        final List<Token> tokenList = new ArrayList<>();
        final String[] lines = text.split("\n");

        tokenListMap.put(label, tokenList);

        int curLine = 1;
        for (String line : lines) {
            try {
                List<LineToken> lineTokenList = tokenizer.tokenize(line);
                for (LineToken lineToken : lineTokenList)
                    tokenList.add(new Token(lineToken, curLine));
                tokenList.add(new Token(StringTokenType.Newline, null, line.length(), curLine));
                curLine++;
            } catch (LexicalAnalysisException exception) {
                throw new LexicalAnalysisException(label, curLine, exception.getColumn());
            }
        }

        return tokenList;
    }

    /**
     * Get the token list of a label.
     */
    List<Token> getTokenList(String label) {
        return tokenListMap.get(label);
    }

    /**
     * Print the token list of a specified label. This method is JUST FOR TEST!
     * @param label a specified label
     */
    public void printTokenList(String label) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Token token : getTokenList(label)) {
            if (token.getTokenType() == StringTokenType.Newline)
                stringBuilder.append('\n');
            else
                stringBuilder.append(token).append(' ');
        }

        System.out.println(stringBuilder);
    }
}
