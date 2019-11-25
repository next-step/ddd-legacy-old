package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {

    static final String DEFAULT_PATTERN_REGEX = "//(.*)\\n(.*)";

    private final Pattern pattern;

    public StringCalculator() {
        this(DEFAULT_PATTERN_REGEX);
    }

    public StringCalculator(final String patternRegex) {
        this.pattern = Pattern.compile(defaultIfPatternRegex(patternRegex));
    }

    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }

        final int[] numbers = parseNumbers(text);
        exceptionNegativeNumber(numbers);
        return Arrays.stream(numbers)
                .sum();
    }

    private boolean isBlank(String text) {
        return text == null || "".equals(text.trim());
    }

    private int[] parseNumbers(String text) {
        return split(text)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private Stream<String> split(String text) {
        final Matcher matcher = pattern.matcher(text);
        final String defaultDelimiter = ",:";

        if (matcher.find()) {
            final String customDelimiter = matcher.group(1);
            final String onlyText = matcher.group(2);

            return splitByDelimiters(onlyText, defaultDelimiter, customDelimiter);
        }

        return splitByDelimiters(text, defaultDelimiter);
    }

    private Stream<String> splitByDelimiters(String text, String... delimiters) {
        final String[] split = text.split("[" + Arrays.toString(delimiters) + "]");
        return Arrays.stream(split);
    }

    private void exceptionNegativeNumber(int[] numbers) {
        final boolean hasNegativeNumber =  Arrays.stream(numbers)
                .anyMatch(number -> number < 0);

        if (hasNegativeNumber) {
            throw new RuntimeException();
        }
    }

    private String defaultIfPatternRegex(String inputPatternRegex) {
        return Optional.ofNullable(inputPatternRegex)
                .filter(regex -> !isBlank(regex))
                .orElse(DEFAULT_PATTERN_REGEX);
    }
}
