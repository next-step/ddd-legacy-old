package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

public class StringCalculator {
    public static final int ZERO = 0;

    public int add(String text) {
        if (isEmpty(text)) {
            return ZERO;
        }

        StringNumbersWithDelimiter stringNumbersWithDelimiter = StringNumbersWithDelimiter.of(text);

        return PositiveNumbers.of(stringNumbersWithDelimiter.toStringNumbers()).
                sum();
    }

    private boolean isEmpty(String text) {
        return StringUtils.isEmpty(StringUtils.trimWhitespace(text));
    }
}
