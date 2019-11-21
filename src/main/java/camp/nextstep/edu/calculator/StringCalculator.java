package camp.nextstep.edu.calculator;

import org.apache.logging.log4j.util.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private final String DEFAULT_DELIMITER = ",|:";

    public int calculate(final String text) {
        if (Strings.isBlank(text)) {
            return Number.ZERO;
        }

        String[] separatedText = separate(text);
        return sum(separatedText);
    }

    private String[] separate(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(Number.TWO)
                          .split(matcher.group(Number.ONE));
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private int sum(final String[] separatedText) {
        Number number = new Number();
        for (int i = Number.ZERO; i < separatedText.length; i++) {
            number.add(separatedText[i]);
        }
        return number.getNumber();
    }
}
