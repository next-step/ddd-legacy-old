package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class StringExpression implements Expression {

    private final List<Positive> positives;

    private StringExpression(final List<Positive> positives) {
        this.positives = positives;
    }

    static Expression of(final String expression) {
        if (Guard.isNullOrBlank(expression)) {
            return NullExpression.INSTANCE;
        }

        return Arrays.stream(Delimiter.delimit(expression))
                .map(Positive::of)
                .collect(collectingAndThen(toList(), StringExpression::new));
    }

    @Override
    public Positive sumAll() {
        return positives.stream()
                .reduce(Positive::sum)
                .orElse(Positive.DEFAULT);
    }
}
