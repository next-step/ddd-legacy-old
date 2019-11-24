package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile(REGEX);

    private static final int DEFAULT_VALUE = 0;

    public int add(String input) {
        if (isEmpty(input)) {
            return DEFAULT_VALUE;
        }

        String[] numbers = parse(input);
        return sum(numbers);
    }

    private boolean isEmpty(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }

    private String[] parse(String input) {
        Matcher matcher = CUSTOM_DELIMITER.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITER);
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(this::parsePositiveNumber)
                .sum();
    }

    private int parsePositiveNumber(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException("문자열 계산기에 음수 사용은 불가합니다.");
        }

        return number;
    }
}
