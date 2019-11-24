package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringNumberParser {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";

    private StringNumberParser() {

    }

    public static String[] parse(String text) {
        if (StringHelper.isNullOrEmpty(text))
            return parseEmptyText();

        final Matcher m = PATTERN.matcher(text);
        if (m.find())
            return parseCustomText(m);

        return parseDefaultText(text);
    }

    private static String[] parseEmptyText() {
        return new String[]{"0"};
    }

    private static String[] parseCustomText(Matcher m) {
        final String delimiter = m.group(1);
        return m.group(2).split(delimiter);
    }

    private static String[] parseDefaultText(String text) {
        return text.split(DEFAULT_DELIMITER);
    }
}
