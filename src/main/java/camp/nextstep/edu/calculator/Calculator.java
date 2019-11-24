package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public int add(String text) {

        Matcher m = pattern.matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return sum(parse(m.group(2), customDelimiter));
        }

        return sum(parse(text, DEFAULT_DELIMITER));
    }

    private int sum(String[] values) {
        return Arrays.stream(values)
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private String[] parse(String text, String delimiter) {
        return text.split(delimiter);
    }

}
