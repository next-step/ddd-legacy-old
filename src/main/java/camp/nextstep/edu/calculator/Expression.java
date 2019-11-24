package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {
    private static final String DEFAULT_SEPARATORS = "(,)|(:)";
    private static final String DEFAULT_SEPARATOR = ",";

    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_END = "\n";

    private final String expression;

    public Expression(String expression) {
        this.validateExpression(expression);

        this.expression = expression;
    }

    boolean isEmpty() {
        return this.isEmptyString(this.expression);
    }

    List<PositiveNumber> retrieveNumbers() {
        final String expressionWithoutCustomSeparator = this.hasCustomSeparator() ?
                this.getExpressionWithoutCustomSeparator() : this.expression;

        final String[] numbers = expressionWithoutCustomSeparator.split(DEFAULT_SEPARATORS);
        return Arrays.stream(numbers)
                .map(number -> new PositiveNumber(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }

    private void validateExpression(String expression) {
        if (this.isEmptyString(expression)) {
            return;
        }

        validateCustomSeparator(expression);
    }

    private boolean isEmptyString(final String expression) {
        return (expression == null) || ("".equals(expression));
    }

    private void validateCustomSeparator(String expression) {
        if (expression.startsWith(CUSTOM_SEPARATOR_START) && !(expression.contains(CUSTOM_SEPARATOR_END))) {
            throw new IllegalArgumentException("Custom separator declaration format is wrong");
        }

        if (!(expression.startsWith(CUSTOM_SEPARATOR_START)) && expression.contains(CUSTOM_SEPARATOR_END)) {
            throw new IllegalArgumentException("Custom separator declaration format is wrong");
        }
    }

    private boolean hasCustomSeparator() {
        if (!(this.expression.startsWith(CUSTOM_SEPARATOR_START))) {
            return false;
        }

        return this.expression.contains(CUSTOM_SEPARATOR_END);
    }

    private String getExpressionWithoutCustomSeparator() {
        final String customSeparator = this.getCustomSeparator();
        return this.removeCustomSeparator(customSeparator);
    }

    private String getCustomSeparator() {
        final int endIndexOfCustomSeparator = this.expression.indexOf(CUSTOM_SEPARATOR_END);
        return this.expression.substring(CUSTOM_SEPARATOR_START.length(), endIndexOfCustomSeparator);
    }

    private String removeCustomSeparator(final String customSeparator) {
        final String customSeparatorRemovedExpression = this.expression.replaceAll(customSeparator, DEFAULT_SEPARATOR);
        final int endIndexOfCustomSeparator = customSeparatorRemovedExpression.indexOf(CUSTOM_SEPARATOR_END);
        return customSeparatorRemovedExpression.substring(endIndexOfCustomSeparator + CUSTOM_SEPARATOR_END.length());
    }
}
