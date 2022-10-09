package pocket.ast2;

public class BinaryOperator extends Operator {
    public static final BinaryOperator Plus = new BinaryOperator("+");
    public static final BinaryOperator Minus = new BinaryOperator("-");
    public static final BinaryOperator Multiply = new BinaryOperator("*");
    public static final BinaryOperator Divide = new BinaryOperator("/");
    public static final BinaryOperator Mod = new BinaryOperator("%");

    private BinaryOperator(String lexeme) {
        super(lexeme);
    }

    public String getLexeme() {
        return lexeme;
    }
}
