package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Expression {
    private static final String DELIMITER = "\\,|\\:";
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static String[] NULL_EXPRESSION = new String[]{};
    private static Matcher matcher;
    public static String EXPRESSION;

    public Expression(String expression) {
        EXPRESSION = expression;
    }

    public static Expression of(String expression) {
        return new Expression(expression);
    }

    public static CalNumbers getCalNumbers() {
        List<CalNumber> list = Arrays.asList(Expression.split())
                .stream()
                .map(CalNumber::new)
                .collect(Collectors.toList());
        return new CalNumbers(list);
    }

    private static String[] split() {
        if (isNullExpression()) {
            return NULL_EXPRESSION;
        }
        if (isCustomDelimiter()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return EXPRESSION.split(DELIMITER);
    }

    private static boolean isCustomDelimiter() {
        matcher = PATTERN.matcher(EXPRESSION);
        return matcher.find();
    }

    private static boolean isNullExpression() {
        if (EXPRESSION == null || EXPRESSION.isEmpty()) {
            return true;
        }
        return false;
    }
}
