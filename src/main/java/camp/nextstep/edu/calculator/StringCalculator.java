package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int DEFAULT_RESULT_NUMBER = 0;
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";

    public int calculate(String input) {
        if (isEmpty(input)) {
            return DEFAULT_RESULT_NUMBER;
        }

        String[] operands = parse(input);

        return sumNumbers(operands);
    }

    private boolean isEmpty(String input) {
        return input == null || "".equals(input.trim());
    }

    private int sumNumbers(String[] operands) {
        return Arrays.stream(operands)
                .mapToInt(this::toPositiveNumber)
                .sum();
    }

    private String[] parse(String source) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(source);

        if (m.find()) {
            return split(m.group(2), m.group(1));
        }

        return split(source, DEFAULT_DELIMITER_REGEX);
    }

    private String[] split(String text, String delimiter) {
        if(isEmpty(delimiter)) {
            throw new IllegalArgumentException("Illegal input: no delimiter entered");
        }

        return text.split(delimiter);
    }

    private int toPositiveNumber(String str) throws NumberFormatException {
        int number = Integer.parseInt(str);

        if(number < 0) {
            throw new NumberFormatException("Illegal input(negative number): " + number);
        }

        return number;
    }
}
