package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.exception.NegativeNumberException;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final int DEFAULT_ZERO_VALUE = 0;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public int add(String text) {

        if (isNullOrEmpty(text)) {
            return DEFAULT_ZERO_VALUE;
        }

        Matcher m = pattern.matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return sum(parse(m.group(2), customDelimiter));
        }

        return sum(parse(text, DEFAULT_DELIMITER));
    }

    private int sum(String[] values) {
        return Arrays.stream(values)
                .mapToInt(this::toInt)
                .sum();
    }

    private String[] parse(String text, String delimiter) {
        return text.split(delimiter);
    }

    private int toInt(String value) {
        int parsedValue = Integer.parseInt(value);

        if (isNegativeNumber(parsedValue)) {
            throw new NegativeNumberException(parsedValue);
        }

        return parsedValue;
    }

    private boolean isNegativeNumber(int parsedValue) {
        return parsedValue < DEFAULT_ZERO_VALUE;
    }

    private boolean isNullOrEmpty(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

}
