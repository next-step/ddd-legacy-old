package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

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
        List<Number> convertedNumbers = convert(numbers);
        return sum(convertedNumbers);
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

    private List<Number> convert(String[] numbers) {
        return  Arrays.stream(numbers)
                .map(Number::of)
                .collect(toList());
    }

    private int sum(List<Number> numbers) {
        return numbers.stream()
                .reduce(Number.zero(), Number::add)
                .toInt();
    }
}
