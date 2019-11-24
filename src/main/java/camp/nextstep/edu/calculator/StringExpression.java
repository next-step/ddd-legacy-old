package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

final class StringExpression implements Expression<String> {

    private final List<CalculateValue> calculateValues;

    private StringExpression(final List<CalculateValue> calculateValues) {
        this.calculateValues = calculateValues;
    }

    static Expression of(final String expression) {
        if (Guard.isNullOrBlank(expression)) {
            return NullExpression.INSTANCE;
        }

        return Arrays.stream(Delimiter.delimit(expression))
                .map(CalculateValue::of)
                .collect(collectingAndThen(toList(), StringExpression::new));
    }

    @Override
    public CalculateValue sumAll() {
        return calculateValues.stream()
                .reduce(CalculateValue.DEFAULT, CalculateValue::sum);
    }

    @Override
    public boolean contains(final String rawValue) {
        final CalculateValue value = CalculateValue.of(rawValue);

        return calculateValues.contains(value);
    }
}
