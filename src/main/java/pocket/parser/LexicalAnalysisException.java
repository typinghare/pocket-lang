package pocket.parser;

/**
 * @author James Chan
 */
public class LexicalAnalysisException extends RuntimeException {
    int column;

    int line;

    String label;

    LexicalAnalysisException(int column) {
        super(String.format("Lexeme on column %d is not parseable.", column));
        this.column = column;
    }

    LexicalAnalysisException(String label, int column, int line) {
        super(String.format("Lexeme on %s:%d:%d is not parseable.", label, line, column));
        this.label = label;
        this.line = line;
        this.column = column;
    }
}
