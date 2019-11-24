package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Expressions {
    private static final int SPLIT_CUSTOM_DELIMITER = 1;
    private static final int SPLIT_CUSTOM_EXPRESSION = 2;
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String[] NULL_EXPRESSION = new String[]{};
    private static final String DEFAULT_DELIMITER = ",|:";

    private static String[] validExpressions;

    private Expressions(String[] expressions) {
        validExpressions = expressions;
    }

    static Expressions of(final String expression) {
        if (isNullExpression(expression)) {
            return new Expressions(NULL_EXPRESSION);
        }
        return new Expressions(split(expression));
    }

    String[] getValidExpressions() {
        return this.validExpressions;
    }

    public static Numbers toNumbers() {
        final List<Number> numbers = new ArrayList<>();
        for (String validaExpression : validExpressions) {
            numbers.add(Number.of(validaExpression));
        }
        return new Numbers(numbers);
    }

    private static String[] split(final String expression) {
        final Matcher matcher = PATTERN.matcher(expression);
        if (isCustomDelimiter(matcher)) {
            return splitByDelimiter(
                    matcher.group(SPLIT_CUSTOM_EXPRESSION), matcher.group(SPLIT_CUSTOM_DELIMITER));
        }
        return splitByDelimiter(expression);
    }

    private static boolean isNullExpression(final String expression) {
        return expression == null || expression.isEmpty();
    }

    private static boolean isCustomDelimiter(final Matcher matcher) {
        return matcher.find();
    }

    private static String[] splitByDelimiter(final String expression, final String customDelimiter) {
        return expression.split(customDelimiter);
    }

    private static String[] splitByDelimiter(final String expression) {
        return expression.split(DEFAULT_DELIMITER);
    }

}
