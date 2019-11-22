package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.util.StringUtils;

public class StringCalculator {

    public int calc(String source) {
        StringFormula formula = StringFormula.parse(source);

        String[] operands = formula.extractOperands();

        return sum(operands);
    }

    private int sum(String[] operands) {
        return Arrays.stream(operands)
            .mapToInt(PositiveNumberUtils::parsePositiveInt)
            .sum();
    }

    static class StringFormula {

        private static final String DELIMITER_REGEX = "[,:]";
        private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*)\n(.*)");
        static final StringFormula EMPTY = new StringFormula(DELIMITER_REGEX, "");
        static final String[] EMPTY_OPERANDS = new String[0];

        private String delimiter;
        private String formula;

        private StringFormula(String delimiter, String formula) {
            this.delimiter = delimiter;
            this.formula = formula;
        }

        static StringFormula parse(String source) {
            if(StringUtils.isEmpty(source)) {
                return EMPTY;
            }
            Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(source);
            if(matcher.find()) {
                return new StringFormula(matcher.group(1), matcher.group(2));
            }
            return new StringFormula(DELIMITER_REGEX, source);
        }

        boolean isEmpty() {
            return StringUtils.isEmpty(formula);
        }

        String[] extractOperands() {
            if (isEmpty()) {
                return EMPTY_OPERANDS;
            }
            return formula.split(delimiter);
        }
    }
}
