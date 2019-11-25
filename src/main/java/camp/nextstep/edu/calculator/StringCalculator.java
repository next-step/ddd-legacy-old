package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private final static String DEFAULT_DELIMETER_TOKEN = "\\,|\\:";
    private final static String CUSTOM_DELIMETER_REGEX = "//(.)\n(.*)";
    private final static Pattern CUSTOM_DELIMETER_PATTERN = Pattern.compile(CUSTOM_DELIMETER_REGEX);

    public int add(final String text) {

        if (isEmptyOrNull(text)) {
            return 0;
        }

        String delimeter = DEFAULT_DELIMETER_TOKEN;
        String numberText = text;
        Matcher matcher = CUSTOM_DELIMETER_PATTERN.matcher(text);
        if (matcher.find()) {
            delimeter = matcher.group(1);
            numberText = matcher.group(2);
        }
        return sum(numberText, delimeter);
    }

    private boolean isEmptyOrNull(final String text) {
        return text == null || text.isEmpty();
    }

    private int sum(final String text, final String delimeter) {
        String[] tokens = text.split(delimeter);
        return Arrays.stream(tokens)
                .mapToInt(this::toPositiveNumber)
                .sum();
    }

    private int toPositiveNumber(final String token) {
        int number = Integer.parseInt(token);
        checkNegativeNumber(number);
        return number;
    }

    private void checkNegativeNumber(final int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException();
        }
    }
}
