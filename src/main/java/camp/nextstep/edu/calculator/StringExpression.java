package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class StringExpression implements Expression {

    private final List<Value> values;

    private StringExpression(final List<Value> values) {
        this.values = values;
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
    public Value sumAll() {
        return values.stream()
                .reduce(Value::sum)
                .orElse(Value.DEFAULT);
    }
}
