package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Delimiter {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int CUSTOM_DELIMITER_LEFT_INDEX = 1;
    private static final int CUSTOM_DELIMITER_RIGHT_INDEX = 2;

    private Delimiter() {
    }

    public static String[] separate(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(CUSTOM_DELIMITER_RIGHT_INDEX)
                          .split(matcher.group(CUSTOM_DELIMITER_LEFT_INDEX));
        }
        return text.split(DEFAULT_DELIMITER);
    }
}
