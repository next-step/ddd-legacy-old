package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;

public class StringUtil {
    public static final String[] NULL_EXPRESSION = new String[]{};
    private static final String DEFAULT_DELIMITER = ",|:";

    public static boolean isCustomDelimiter(Matcher matcher) {
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static String[] splitByCustomDelimiter(String expression, String customDelimiter) {
        return expression.split(customDelimiter);
    }

    public static String[] splitByDefaultDelimiter(String expression) {
        return expression.split(DEFAULT_DELIMITER);
    }
}
