package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Expression {
    private static final int MINUS_INDEX = 1;
    private static final String DELIMITER = "\\,|\\:";
    private static final String[] NULL_EXPRESSION = new String[]{};
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private int lastValueIndex;
    private String[] validExpressions;
    private String expression;
    private String customDelimiter;

    private Expression(final String expression) {
        this.expression = expression;
        this.validExpressions = split();
        this.lastValueIndex = this.validExpressions.length - MINUS_INDEX;
        System.out.println(this.toString());
    }

    public static Expression of(final String expression) {
        return new Expression(expression);
    }

    public String[] getExpressions() {
        return this.validExpressions;
    }

    private String[] split() {
        if (isNullExpression()) {
            return NULL_EXPRESSION;
        }
        if (isCustomDelimiter(this.expression)) {
            return this.expression.split(this.customDelimiter);
        }
        return this.expression.split(DELIMITER);
    }

    private boolean isCustomDelimiter(String expression) {
        Matcher matcher = PATTERN.matcher(expression);
        if (matcher.find()) {
            this.expression = matcher.group(2);
            this.customDelimiter = matcher.group(1);
            return true;
        }
        return false;
    }

    private boolean isNullExpression() {
        return this.expression == null || this.expression.isEmpty();
    }

    @Override
    public String toString() {
        return "lastValueIndex: " + lastValueIndex + ", validExpression: "
                + Arrays.stream(validExpressions).collect(Collectors.joining("+"))
                + ", expression: " + expression + ", []size: " + validExpressions.length;
    }
}
