package camp.nextstep.edu.calculator;

import java.util.Arrays;
import org.springframework.util.StringUtils;

public class StringCalculator {

    private static final String DELIMITER_REGEX = "[,:]";

    public int calc(String source) {
        if(StringUtils.isEmpty(source)) {
            return 0;
        }
        String[] split = source.split(DELIMITER_REGEX);

        return Arrays.stream(split)
            .mapToInt(StringCalculator::parsePositiveInt)
            .sum();
    }

    private static int parsePositiveInt(String s) throws NumberFormatException {
        int i = Integer.parseInt(s);
        if(i < 0) {
            throw new NumberFormatException("It is not positive numbers. string: \"" + s + "\"");
        }
        return i;
    }
}
