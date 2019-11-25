package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.number.Numbers;
import camp.nextstep.edu.calculator.splitter.Splitter;
import camp.nextstep.edu.calculator.splitter.SplitterRegistry;

public class StringCalculator {

    private final SplitterRegistry splitterRegistry;

    public StringCalculator(SplitterRegistry splitterRegistry) {
        this.splitterRegistry = splitterRegistry;
    }

    public int sum(String value) {
        Splitter splitter = splitterRegistry.getSplitter(value);

        Numbers numbers = Numbers.parse(splitter.split(value));

        return numbers.sumValue();
    }

}
