package camp.nextstep.edu.calculator.expression;

import camp.nextstep.edu.calculator.value.Number;
import camp.nextstep.edu.calculator.value.Zero;

enum NullExpression implements Expression {

    INSTANCE;

    @Override
    public Number sumAll() {
        return Zero.INSTANCE;
    }

    @Override
    public boolean contains(Expression ignored) {
        return false;
    }
}
