package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.util.StringUtils;

public class StringCalculator {

    private static final String DELIMITER_REGEX = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*)\n(.*)");

    public int calc(String source) {
        if(StringUtils.isEmpty(source)) {
            return 0;
        }
        String[] operands = extractOperands(source);

        return Arrays.stream(operands)
            .mapToInt(StringCalculator::parsePositiveInt)
            .sum();
    }

    private String[] extractOperands(String source) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(source);
        if(matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return source.split(DELIMITER_REGEX);
    }

    private static int parsePositiveInt(String s) throws NumberFormatException {
        int i = Integer.parseInt(s);
        if(i < 0) {
            throw new NumberFormatException("It is not positive numbers. string: \"" + s + "\"");
        }
        return i;
    }
}
