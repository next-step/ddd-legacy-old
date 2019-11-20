package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

class Expression {

    static final String DEFAULT_SEPARATOR = "[,:]";

    private static final Pattern CUSTOM_HAS_SEPARATOR = Pattern.compile("//(.)\n(.*)");
    private static final int INDEX_OF_SEPARATOR = 1;
    private static final int INDEX_OF_EXPRESSION = 2;

    private final List<PositiveNumber> positiveNumbers;

    private Expression(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    static Expression of(String inputOfExpression) {
        Matcher matcher = CUSTOM_HAS_SEPARATOR.matcher(inputOfExpression);
        if (matcher.find()) {
            return Expression.of(matcher.group(INDEX_OF_SEPARATOR), matcher.group(INDEX_OF_EXPRESSION));
        }
        return Expression.of(DEFAULT_SEPARATOR, inputOfExpression);
    }

    private static Expression of(String separator, String expression) {
        return Arrays.stream(expression.split(separator))
                     .map(PositiveNumber::of)
                     .collect(Collectors.collectingAndThen(toList(), Expression::new));
    }

    int sum() {
        return positiveNumbers.stream()
                              .reduce(PositiveNumber.ZERO, PositiveNumber::add)
                              .parseInt();
    }

    List<PositiveNumber> getNumbers() {
        return Collections.unmodifiableList(positiveNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Objects.equals(positiveNumbers, that.positiveNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positiveNumbers);
    }

    @Override
    public String toString() {
        return "Expression{" +
                "positiveNumbers=" + positiveNumbers +
                '}';
    }
}
