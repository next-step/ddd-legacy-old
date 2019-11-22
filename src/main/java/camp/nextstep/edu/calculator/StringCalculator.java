package camp.nextstep.edu.calculator;

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
