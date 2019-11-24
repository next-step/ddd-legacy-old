package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

final class StringExpression implements Expression {

    private final List<Number> numbers;

    private StringExpression(final List<Number> numbers) {
        this.numbers = numbers;
    }

    static Expression of(final String expression) {
        if (Guard.isNullOrBlank(expression)) {
            return NullExpression.INSTANCE;
        }

        return Arrays.stream(Delimiter.delimit(expression))
                .map(Value::of)
                .collect(collectingAndThen(toList(), StringExpression::new));
    }

    @Override
    public Number sumAll() {
        return numbers.stream()
                .reduce(Number::sum)
                .orElse(Zero.INSTANCE);
    }

    @Override
    public boolean contains(final Expression expression) {
        if (notMatchClass(expression)) {
            return false;
        }
        final StringExpression that = (StringExpression) expression;
        return numbers.containsAll(that.numbers);
    }

    private boolean notMatchClass(Expression expression) {
        return Objects.isNull(expression) || getClass() != expression.getClass();
    }
}
