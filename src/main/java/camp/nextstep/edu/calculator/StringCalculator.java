package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String SPLITTER = "\\,|\\:";
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    private int sum;

    public StringCalculator() {
        sum = 0;
    }

    public int add(String text) {
        if (isZero(text)) {
            return 0;
        }
        return sum += getSum(split(text));
    }

    private String[] split(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return text.split(SPLITTER);
    }

    private int getSum(String[] texts) {
        for (String text : texts) {
            sum += parse(text);
        }
        return sum;
    }

    private int parse(String text) {
        int value = Integer.parseInt(text);
        if (value <= 0) {
            throw new RuntimeException();
        }
        return value;
    }

    private boolean isZero(String text) {
        if (checkNull(text) || checkNullString(text)) {
            return true;
        }
        return false;
    }

    private boolean checkNull(String text) {
        if (text == null) {
            return true;
        }
        return false;
    }

    private boolean checkNullString(String text) {
        if (text.isEmpty()) {
            return true;
        }
        return false;
    }

}
