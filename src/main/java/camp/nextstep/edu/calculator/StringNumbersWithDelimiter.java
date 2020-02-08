package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringNumbersWithDelimiter {
    static final String DEFAULT_DELIMITER = ",|:";
    /**
     * 커스텀 구분자는 문자열 맨 앞의 "//"와 "\n" 사이에 위치 한다.
     */
    private static final String REG_EXP_CUSTOM_DELIMITER = "^//(.)\n(.*)$";

    public static final int DELIMITER_INDEX = 1;
    public static final int STRING_NUMBER_INDEX = 2;

    private String delimiter;
    private String stringNumbersWithDelimiter;

    public StringNumbersWithDelimiter(String delimiter, String stringNumbersWithDelimiter) {
        this.delimiter = delimiter;
        this.stringNumbersWithDelimiter = stringNumbersWithDelimiter;
    }

    public static StringNumbersWithDelimiter of(String text) {
        Matcher matcher = Pattern.compile(REG_EXP_CUSTOM_DELIMITER).matcher(text);
        if (matcher.find()) {
            return new StringNumbersWithDelimiter(matcher.group(DELIMITER_INDEX), matcher.group(STRING_NUMBER_INDEX));
        }
        return new StringNumbersWithDelimiter(DEFAULT_DELIMITER, text);
    }

    public String[] toStringNumbers() {
        return stringNumbersWithDelimiter.split(delimiter);
    }
}
