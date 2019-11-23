package camp.nextstep.edu.calculator;

import java.util.List;

public class StringCalculator {
    private StringSplitStrategy splitStrategy;

    public StringCalculator() {
        splitStrategy = DefaultStringSplitStrategy.getInstance();
    }

    public StringCalculator(StringSplitStrategy splitStrategy) {
        this.splitStrategy = splitStrategy;
    }

    public PositiveNumber calculateSum(String input) {
        List<String> splitStrings = splitStrategy.apply(input);
        List<PositiveNumber> numbers = PositiveNumber.parseStrings(splitStrings);
        PositiveNumber result = numbers.stream().reduce((prev,next) -> prev.add(next)).get();
        return result;
    }
}
