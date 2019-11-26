package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumbersExtractor implements Extractor {
    private static final int DEFAULT_VALUE = 0;
    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int INPUT_VALUE_GROUP_INDEX = 2;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(DELIMITER_PATTERN);

    private NumbersExtractor() {
    }

    public static NumbersExtractor of() {
        return new NumbersExtractor();
    }

    private String[] split(final String input) {
        final Matcher m = PATTERN.matcher(input);
        if (m.find()) {
            final String customDelimiter = m.group(DELIMITER_GROUP_INDEX);
            return m.group(INPUT_VALUE_GROUP_INDEX).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private Numbers parseInt(final String[] values) {
        return new Numbers(
                Arrays.stream(values)
                        .mapToInt(Integer::parseInt)
                        .mapToObj(PositiveOrZeroNumber::of)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Numbers get(final String value) {
        if (StringUtils.isEmpty(value)) {
            return new Numbers(PositiveOrZeroNumber.of(DEFAULT_VALUE));
        }
        final String[] values = split(value);
        return parseInt(values);
    }
}
