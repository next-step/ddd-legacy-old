package camp.nextstep.edu.calculator;

import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

public class StringCalculator implements Calculator {

    static final int ZERO = 0;

    @Override
    public int add(String inputOfExpression) {
        if (Objects.isNull(Strings.trimToNull(inputOfExpression))) {
            return ZERO;
        }

        Expression expression = Expression.of(inputOfExpression);
        return expression.sum();
    }
}
