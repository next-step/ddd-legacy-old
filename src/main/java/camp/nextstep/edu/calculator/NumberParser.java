package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class NumberParser {
    private static final String BASIC_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static List<Number> parse(String input) {
        String customDelimiter = getCustomDelimiter(input);
        String delimiter = StringUtils.isEmpty(customDelimiter) ? BASIC_DELIMITER : customDelimiter;

        return Arrays.stream(input.split(delimiter))
                .map(val -> val.replaceAll(" ", ""))
                .map(Number::new)
                .collect(toList());
    }

    public static String getCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }
}
