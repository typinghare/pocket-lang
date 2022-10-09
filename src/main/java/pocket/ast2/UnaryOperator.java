package pocket.ast2;

/**
 * @author James Chan
 */
public class UnaryOperator extends Operator {
    public static final UnaryOperator UnaryMinus = new UnaryOperator("-");
    public static final UnaryOperator Increment = new UnaryOperator("++");
    public static final UnaryOperator Decrement = new UnaryOperator("--");
    public static final UnaryOperator Not = new UnaryOperator("!");

    public UnaryOperator(String lexeme) {
        super(lexeme);
    }
}
