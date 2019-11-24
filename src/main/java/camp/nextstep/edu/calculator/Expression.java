package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {
    private static final String DEFAULT_SEPARATORS = "(,)|(:)";
    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_END = "\n";

    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    boolean isEmpty() {
        return this.isEmptyString(this.expression);
    }

    List<PositiveNumber> retrieveNumbers() {
        final String[] numbers = this.expression.split(DEFAULT_SEPARATORS);
        return Arrays.stream(numbers)
                .map(number -> new PositiveNumber(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }

    private boolean isEmptyString(final String expression) {
        return (expression == null) || ("".equals(expression));
    }
}
