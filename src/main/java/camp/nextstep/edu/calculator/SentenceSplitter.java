package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.thymeleaf.util.StringUtils;

public class SentenceSplitter {
    private static final Pattern DEFAULT_SPLIT_PATTERN = Pattern.compile(":|,");
    private static final Pattern CUSTOM_SPLIT_REGEX = Pattern.compile("//(.)\\n(.*)");

    public static List<String> split(String input) {
        if (StringUtils.isEmpty(input)) {
            return Collections.emptyList();
        }
        Matcher matcher = CUSTOM_SPLIT_REGEX.matcher(input);
        if (!matcher.find()) {
            return splitByDelimiter(DEFAULT_SPLIT_PATTERN, input);
        }

        Pattern delimiter = Pattern.compile(matcher.group(1), Pattern.LITERAL);
        String target = matcher.group(2);
        return splitByDelimiter(delimiter, target);
    }

    private static List<String> splitByDelimiter(Pattern pattern, String input) {
        return Arrays.asList(pattern.split(input));
    }
}
