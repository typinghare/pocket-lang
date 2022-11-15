package pocket.pvm.evaluator;

import pocket.ast.expr.BinaryExpr;
import pocket.ast.expr.Expr;
import pocket.pvm.Evaluator;
import pocket.pvm.PocketVirtualMachine;
import pocket.pvm.lang.type.PocketFloat;
import pocket.pvm.lang.type.PocketInt;
import pocket.pvm.lang.type.PocketNumber;
import pocket.pvm.lang.type.PocketObject;

/**
 * Binary expression evaluator.
 */
public class BinaryExprEvaluator extends Evaluator {
    public BinaryExprEvaluator(PocketVirtualMachine pocketVirtualMachine) {
        super(pocketVirtualMachine);
    }

    @Override
    public PocketObject evaluate(Expr expr) {
        assert expr instanceof BinaryExpr;

        final PocketObject leftValue = super.evaluate(((BinaryExpr) expr).getLeft());
        final PocketObject rightValue = super.evaluate(((BinaryExpr) expr).getRight());

        return switch (((BinaryExpr) expr).getOp()) {
            case Plus -> evaluatePlus(leftValue, rightValue);
            case Minus -> evaluateMinus(leftValue, rightValue);
            case Multiply -> evaluateMultiply(leftValue, rightValue);
            case Mod -> evaluateMod(leftValue, rightValue);
            case Divide -> evaluateDivide(leftValue, rightValue);
        };
    }

    /**
     * Evaluates plus binary operation.
     * @param leftValue  left value
     * @param rightValue right value
     * @return the value after operation
     */
    public PocketObject evaluatePlus(PocketObject leftValue, PocketObject rightValue) {
        // now only support number plus number
        if (leftValue instanceof PocketNumber && rightValue instanceof PocketNumber) {
            final Number leftNumber = ((PocketNumber) leftValue).getValue();
            final Number rightNumber = ((PocketNumber) rightValue).getValue();
            if (leftValue instanceof PocketInt && rightValue instanceof PocketInt) {
                final int resultValue = leftNumber.intValue() + rightNumber.intValue();
                return new PocketInt(resultValue);
            } else {
                final float resultValue = leftNumber.floatValue() + rightNumber.floatValue();
                return new PocketFloat(resultValue);
            }
        } else {
            throw new RuntimeException("Eval plus.");
        }
    }

    public PocketObject evaluateMinus(PocketObject leftValue, PocketObject rightValue) {
        // now only support number plus number
        if (leftValue instanceof PocketNumber && rightValue instanceof PocketNumber) {
            final Number leftNumber = ((PocketNumber) leftValue).getValue();
            final Number rightNumber = ((PocketNumber) rightValue).getValue();
            if (leftValue instanceof PocketInt && rightValue instanceof PocketInt) {
                final int resultValue = leftNumber.intValue() - rightNumber.intValue();
                return new PocketInt(resultValue);
            } else {
                final float resultValue = leftNumber.floatValue() - rightNumber.floatValue();
                return new PocketFloat(resultValue);
            }
        } else {
            throw new RuntimeException("Eval minus.");
        }
    }

    public PocketObject evaluateMultiply(PocketObject leftValue, PocketObject rightValue) {
        // now only support number plus number
        if (leftValue instanceof PocketNumber && rightValue instanceof PocketNumber) {
            final Number leftNumber = ((PocketNumber) leftValue).getValue();
            final Number rightNumber = ((PocketNumber) rightValue).getValue();
            if (leftValue instanceof PocketInt && rightValue instanceof PocketInt) {
                final int resultValue = leftNumber.intValue() * rightNumber.intValue();
                return new PocketInt(resultValue);
            } else {
                final float resultValue = leftNumber.floatValue() * rightNumber.floatValue();
                return new PocketFloat(resultValue);
            }
        } else {
            throw new RuntimeException("Eval multiply.");
        }
    }

    public PocketObject evaluateDivide(PocketObject leftValue, PocketObject rightValue) {
        // now only support number plus number
        if (leftValue instanceof PocketNumber && rightValue instanceof PocketNumber) {
            final Number leftNumber = ((PocketNumber) leftValue).getValue();
            final Number rightNumber = ((PocketNumber) rightValue).getValue();
            if (leftValue instanceof PocketInt && rightValue instanceof PocketInt) {
                final int resultValue = leftNumber.intValue() / rightNumber.intValue();
                return new PocketInt(resultValue);
            } else {
                final float resultValue = leftNumber.floatValue() / rightNumber.floatValue();
                return new PocketFloat(resultValue);
            }
        } else {
            throw new RuntimeException("Eval divide.");
        }
    }

    public PocketObject evaluateMod(PocketObject leftValue, PocketObject rightValue) {
        // now only support number plus number
        if (leftValue instanceof PocketNumber && rightValue instanceof PocketNumber) {
            final Number leftNumber = ((PocketNumber) leftValue).getValue();
            final Number rightNumber = ((PocketNumber) rightValue).getValue();
            if (leftValue instanceof PocketInt && rightValue instanceof PocketInt) {
                final int resultValue = leftNumber.intValue() % rightNumber.intValue();
                return new PocketInt(resultValue);
            } else {
                final float resultValue = leftNumber.floatValue() % rightNumber.floatValue();
                return new PocketFloat(resultValue);
            }
        } else {
            throw new RuntimeException("Eval mod.");
        }
    }
}
