package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringNumberParser {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";

    public StringNumberParser() {

    }

    public String[] parse(String text) {
        if (StringHelper.isNullOrEmpty(text))
            return this.parseEmptyText();

        final Matcher m = PATTERN.matcher(text);
        if (m.find())
            return this.parseCustomText(m);

        return this.parseDefaultText(text);
    }

    private String[] parseEmptyText() {
        return new String[]{"0"};
    }

    private String[] parseCustomText(Matcher m) {
        final String delimiter = m.group(1);
        return m.group(2).split(delimiter);
    }

    private String[] parseDefaultText(String text) {
        return text.split(DEFAULT_DELIMITER);
    }
}
