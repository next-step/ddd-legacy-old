package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String CUSTOM_DELIMITER = "//(.)\\n(.*)";

    private CalculatorNumbers calculatorNumbers;

    public StringCalculator() {
        calculatorNumbers = new CalculatorNumbers();
    }

    public int add(final String text) {

        if(StringChecker.isEmpty(text)) return 0;

        Delimiter delimiter = this.findNumberText(text);

        calculatorNumbers.add(delimiter.getNumbers());

        return calculatorNumbers.totalSum();
    }

    private Delimiter findNumberText(final String text){

        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        if( m.find() ){
            return new Delimiter(m.group(2), m.group(1));
        }

        return new Delimiter(text, ",|:");
    }

}
