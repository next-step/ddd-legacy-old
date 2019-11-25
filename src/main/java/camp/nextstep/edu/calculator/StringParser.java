package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringParser {
    private final String REGEX = "//(.)\n(.*)";
    private final String DELIMITER = ",|:";

    String[] parse(String text) {
        Matcher m = Pattern.compile(REGEX).matcher(text);

        return m.find() ? m.group(2).split(m.group(1)) : text.split(DELIMITER);
    }
}
