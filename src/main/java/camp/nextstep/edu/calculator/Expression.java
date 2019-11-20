package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Expression {

    static final String DEFAULT_SEPARATOR = ",|:";

    private static final Pattern CUSTOM_HAS_SEPARATOR = Pattern.compile("//(.)\n(.*)");
    private static final int INDEX_OF_SEPARATOR = 1;
    private static final int INDEX_OF_EXPRESSION = 2;

    private final String[] numbers;

    private Expression(String[] numbers) {
        this.numbers = numbers;
    }

    static Expression of(String inputOfExpression) {
        Matcher matcher = CUSTOM_HAS_SEPARATOR.matcher(inputOfExpression);
        if (matcher.find()) {
            String separator = matcher.group(INDEX_OF_SEPARATOR);
            String[] numbers = matcher.group(INDEX_OF_EXPRESSION)
                                      .split(separator);
            return new Expression(numbers);
        }
        return new Expression(inputOfExpression.split(DEFAULT_SEPARATOR));
    }

    int sum() {
        return Arrays.stream(numbers)
              .mapToInt(Integer::valueOf)
              .sum();
    }

    String[] getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Arrays.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }

    @Override
    public String toString() {
        return "Expression{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}
