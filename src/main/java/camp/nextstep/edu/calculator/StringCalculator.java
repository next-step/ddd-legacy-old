package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*)\n(.*)$");
    public static final Pattern ONLY_USED_DEFAULT_DELIMITER = Pattern.compile("^[0-9:,]+$");
    public static final Pattern ONLY_USED_NUMERIC_AND_HYPHEN = Pattern.compile("^[0-9-]+$");

    public static final int MATCHER_GROUP_INDEX_DELIMITER = 1;
    public static final int MATCHER_GROUP_INDEX_VALUE = 2;

    public int add(String value) {

        if (value == null || value.isEmpty()) {
            return 0;
        }

        if (ONLY_USED_NUMERIC_AND_HYPHEN.matcher(value).matches()) {
            return parseIntAndThrowExceptionIfNumberIsNegative(value);
        }

        if (ONLY_USED_DEFAULT_DELIMITER.matcher(value).matches()) {
            String[] values = value.replaceAll(":", ",").split(",");
            return sum(values);
        }

        Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(value);
        if (customDelimiterMatcher.matches()) {
            String customDelimiter = customDelimiterMatcher.group(MATCHER_GROUP_INDEX_DELIMITER);
            String customDelimiterValues = customDelimiterMatcher.group(MATCHER_GROUP_INDEX_VALUE);

            return sum(customDelimiterValues.split(customDelimiter));
        }

        throw new RuntimeException("Invalid value");
    }

    private int sum(String[] values) {
        int sum = 0;
        for (int i = 0, size = values.length; i < size; i++) {
            sum += parseIntAndThrowExceptionIfNumberIsNegative(values[i]);
        }
        return sum;
    }

    private int parseIntAndThrowExceptionIfNumberIsNegative(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("Negative numbers are not allowed");
        }
        return number;
    }

}
