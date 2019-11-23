package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.logging.log4j.util.Strings;
import org.thymeleaf.util.StringUtils;

public class CustomStringSplitStrategy implements StringSplitStrategy {
    public static final Pattern CUSTOM_SPLIT_REGEX = Pattern.compile("//(.*)\n");
    private static final Pattern CUSTOM_IGNORE_REGEX = Pattern.compile("(//.*\n)");
    private final Pattern splitRegex;

    CustomStringSplitStrategy(String... splitStrings) {
        if (null == splitStrings || splitStrings.length == 0) {
            throw new IllegalArgumentException("splitStrings must be not empty");
        }
        //escape
        String[] escaped = escapeCharacters(splitStrings);
        String splitRegex = StringUtils.join(escaped, "|");
        this.splitRegex = Pattern.compile(splitRegex);
    }

    @Override
    public List<String> apply(String input) {
        input = CUSTOM_IGNORE_REGEX.matcher(input).replaceAll(Strings.EMPTY);
        return Arrays.asList(splitRegex.split(input));
    }
}
