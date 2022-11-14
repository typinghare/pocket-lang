package pocket.vm.evaluator;

import pocket.ast.expr.BinaryExpr;
import pocket.ast.expr.Expr;
import pocket.ast.operator.BinaryOp;
import pocket.vm.Pvm;
import pocket.vm.type.PocketFloat;
import pocket.vm.type.PocketInt;
import pocket.vm.type.PocketNumber;
import pocket.vm.type.PocketObject;

public class BinaryExprEvaluator extends Evaluator {

    @Override
    public PocketObject eval(Expr expr) {
        assert expr instanceof BinaryExpr;
        final Expr left = ((BinaryExpr) expr).getLeft();
        final Expr right = ((BinaryExpr) expr).getRight();
        final BinaryOp binaryOp = ((BinaryExpr) expr).getOperator();

        final PocketObject leftValue = Pvm.instance().eval(left);
        final PocketObject rightValue = Pvm.instance().eval(right);

        return switch (binaryOp) {
            case Plus -> evalPlus(leftValue, rightValue);
            case Minus -> evalMinus(leftValue, rightValue);
            case Multiply -> evalMultiply(leftValue, rightValue);
            case Mod -> evalMod(leftValue, rightValue);
            case Divide -> evalDivide(leftValue, rightValue);
        };
    }

    public PocketObject evalPlus(PocketObject leftValue, PocketObject rightValue) {
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

    public PocketObject evalMinus(PocketObject leftValue, PocketObject rightValue) {
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

    public PocketObject evalMultiply(PocketObject leftValue, PocketObject rightValue) {
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

    public PocketObject evalDivide(PocketObject leftValue, PocketObject rightValue) {
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
            throw new RuntimeException("Eval mod.");
        }
    }

    public PocketObject evalMod(PocketObject leftValue, PocketObject rightValue) {
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
