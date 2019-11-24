package camp.nextstep.edu.calculator;

import java.util.List;

public class StringAdder {

    private StringAdder() {
        throw new IllegalStateException("StringAdder is an util class");
    }

    public static int calculate(final Expression expression) {
        if (expression.isEmpty()) {
            return 0;
        }

        final List<PositiveNumber> numbers = expression.retrieveNumbers();
        return getSumOf(numbers).toInt();
    }

    private static PositiveNumber getSumOf(final List<PositiveNumber> numbers) {
        return numbers.stream()
                .reduce(PositiveNumber::add)
                .orElseGet(() -> new PositiveNumber(0));
    }
}
