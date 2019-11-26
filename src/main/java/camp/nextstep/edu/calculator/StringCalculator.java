package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.exception.NegativeNumberException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.util.StringUtils;

public class StringCalculator {

    private static final String DELIMITER = ",|:";
    private static final String PATTERN_DELIMITER = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(PATTERN_DELIMITER);
    private static final int ZERO_VALUE = 0;

    /**
     * Add string of integer numbers which is included with comma(,) or colon(:)
     *
     * @param numbersText
     * @return sum of integer numbers
     */
    public int add(final String numbersText) {
        if (StringUtils.isEmpty(numbersText)) {
            return 0;
        }

        Matcher matcher = PATTERN.matcher(numbersText);

        if (matcher.find()) {
            String patternDelimeter = matcher.group(1);
            return sum(split(matcher.group(2), patternDelimeter));
        }

        return sum(split(numbersText, DELIMITER));
    }

    /**
     * Sum of integer numbers
     *
     * @param numbers
     * @return sum of integer numbers
     */
    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
            .mapToInt(this::parseInt)
            .sum();
    }

    /**
     * Parse string number into integer number
     *
     * @param number
     * @return parsed integer value
     */
    private int parseInt(final String number) {
        int parsedNumber = Integer.parseInt(number);

        if (isNegativeNumber(parsedNumber)) {
            throw new NegativeNumberException(parsedNumber);
        }

        return parsedNumber;
    }

    /**
     * Check whether positive number or not
     *
     * @param number
     * @return boolean value whether positive number or not
     */
    private boolean isNegativeNumber(final int number) {
        return number < ZERO_VALUE;
    }

    /**
     * Split string of integer numbers which is included with delimiter
     *
     * @param numbersText
     * @param delimiter
     * @return String array splited by delimiter
     */
    private String[] split(String numbersText, String delimiter) {
        return numbersText.split(delimiter);
    }

}
