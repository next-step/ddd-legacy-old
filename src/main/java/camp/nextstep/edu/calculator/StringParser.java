package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringParser {
    private static final String REGEX = "//(.)\n(.*)";
    private static final String DELIMITER = ",|:";
    private static final Pattern REGEX_PATTERN = Pattern.compile(REGEX);

    String[] toStringArrayFrom(String text) {
        Matcher m = REGEX_PATTERN.matcher(text);

        return m.find() ? m.group(2).split(m.group(1)) : text.split(DELIMITER);
    }

    Integer toIntFrom(String text){
        return Integer.parseInt(text);
    }
}
