package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.expression.Expression;
import camp.nextstep.edu.calculator.expression.StringExpression;
import camp.nextstep.edu.calculator.value.Number;

final class StringCalculator implements Calculator<String> {

    @Override
    public int calculate(final String rawExpression) {
        final Expression expression = StringExpression.of(rawExpression);
        final Number result = expression.sumAll();

        return result.intValue();
    }
}
