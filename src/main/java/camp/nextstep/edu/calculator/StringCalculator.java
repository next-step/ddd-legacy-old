package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.number.Numbers;
import camp.nextstep.edu.calculator.splitter.Splitter;
import camp.nextstep.edu.calculator.splitter.SplitterRegistry;

public class StringCalculator {

    private final SplitterRegistry splitterRegistry;

    public StringCalculator(SplitterRegistry splitterRegistry) {
        this.splitterRegistry = splitterRegistry;
    }

    public int sum(String stringValue) {
        Splitter splitter = splitterRegistry.getSplitter(stringValue);

        Numbers numbers = Numbers.parse(splitter.split(stringValue));

        return numbers.sumValue();
    }

}
