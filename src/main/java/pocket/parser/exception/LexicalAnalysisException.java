package pocket.parser.exception;

/**
 * @author James Chan
 */
public class LexicalAnalysisException extends RuntimeException {
    final int column;

    final int line;

    final String label;

    public LexicalAnalysisException(int column) {
        super(String.format("Lexeme on column %d is not parseable.", column));
        this.column = column;
        this.line = 1;
        this.label = null;
    }

    public LexicalAnalysisException(String label, int column, int line) {
        super(String.format("Lexeme on %s:%d:%d is not parseable.", label, line, column));
        this.label = label;
        this.line = line;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public int getLine() {
        return line;
    }

    public String getLabel() {
        return label;
    }
}
