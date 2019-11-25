package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Extractor {
    private static final int DEFAULT_VALUE = 0;
    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int INPUT_VALUE_GROUP_INDEX = 2;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(DELIMITER_PATTERN);

    public static List<Integer> getNumbers(final String input) {
        if (StringUtils.isEmpty(input)) {
            return Collections.singletonList(DEFAULT_VALUE);
        }

        final String[] split = split(input);

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] split(final String input) {
        final Matcher m = PATTERN.matcher(input);
        if (m.find()) {
            final String customDelimiter = m.group(DELIMITER_GROUP_INDEX);
            return m.group(INPUT_VALUE_GROUP_INDEX).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }
}
