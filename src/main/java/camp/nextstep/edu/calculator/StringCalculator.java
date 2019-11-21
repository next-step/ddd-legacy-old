package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DELIMITER = "\\,|\\:";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public int add(String text) {
        if (isEmptyOrNull(text)) {
            return 0;
        }

        return sum(text);
    }

    private boolean isEmptyOrNull(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }

        return false;
    }

    private int sum(String text) {
        return Arrays.stream(splitInputText(text))
                .mapToInt(Integer::parseInt)
                .filter(i -> {
                    checkNegativeNumber(i);
                    return true;
                })
                .sum();
    }

    private String[] splitInputText(String text) {
        Matcher m = CUSTOM_DELIMITER.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(DELIMITER);
    }

    private void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
