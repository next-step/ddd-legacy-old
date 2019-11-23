package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final int SPLIT_CUSTOM_DELIMITER = 1;
    private static final int SPLIT_CUSTOM_EXPRESSION = 2;
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    private String[] validExpressions;

    private Expression(final String expression) {
        this.validExpressions = split(expression);
    }

    public static Expression of(final String expression) {
        return new Expression(expression);
    }

    public String[] getExpressions() {
        return this.validExpressions;
    }

    private String[] split(String expression) {
        if (isNullExpression(expression)) {
            return StringUtil.NULL_EXPRESSION;
        }

        Matcher matcher = PATTERN.matcher(expression);
        if (StringUtil.isCustomDelimiter(matcher)) {
            return StringUtil.splitByCustomDelimiter(
                    matcher.group(SPLIT_CUSTOM_EXPRESSION), matcher.group(SPLIT_CUSTOM_DELIMITER));
        }
        return StringUtil.splitByDefaultDelimiter(expression);
    }

    private boolean isNullExpression(String expression) {
        return expression == null || expression.isEmpty();
    }

}
