package pocket.parser;

import java.util.List;
import java.util.Stack;

/**
 * @author James Chan
 */
public class TokenProvider {
    private final List<Token> tokenList;

    private int index = 0;

    private final Stack<Integer> records = new Stack<>();

    TokenProvider(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    Token next() {
        return tokenList.get(index++);
    }

    Token peek(int offset) {
        return tokenList.get(index + offset);
    }

    void record() {
        this.records.push(index);
    }

    void revoke() {
        this.index = records.pop();
    }
}
