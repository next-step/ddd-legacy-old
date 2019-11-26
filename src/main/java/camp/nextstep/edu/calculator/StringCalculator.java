package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculator {

    private static final String CUSTOM_DELIMITER = "//(.)\\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|:";

    private Pattern pattern;

    private CalculatorNumbers calculatorNumbers;

    StringCalculator() {
        calculatorNumbers = new CalculatorNumbers();
        pattern = Pattern.compile(CUSTOM_DELIMITER);
    }

    int add(final String text) {

        if (StringChecker.isEmpty(text)) {
            return 0;
        }

        Delimiter delimiter = this.findNumberText(text);

        calculatorNumbers.add(delimiter.getNumbers());
        return calculatorNumbers.totalSum();
    }

    private Delimiter findNumberText(final String text) {

        Matcher m = pattern.matcher(text);
        if (m.find()) {
            return new Delimiter(m.group(2), m.group(1));
        }

        return new Delimiter(text, DEFAULT_DELIMITER);
    }

}
