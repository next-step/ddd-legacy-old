package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final int MINUS_INDEX = 1;
    private static final String DELIMITER = "\\,|\\:";
    private static final String[] NULL_EXPRESSION = new String[]{};
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int SPLIT_CUSTOM_DELIMITER = 1;
    private static final int SPLIT_CUSTOM_EXPRESSION = 2;
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
            this.expression = matcher.group(SPLIT_CUSTOM_EXPRESSION);
            this.customDelimiter = matcher.group(SPLIT_CUSTOM_DELIMITER);
            return true;
        }
        return false;
    }

    private boolean isNullExpression() {
        return this.expression == null || this.expression.isEmpty();
    }

}
