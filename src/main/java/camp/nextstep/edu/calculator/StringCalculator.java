package camp.nextstep.edu.calculator;

import java.util.List;

public class StringCalculator {

    public long calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0L;
        }
        List<String> splitStrings = SentenceSplitter.split(input);
        List<PositiveNumber> numbers = PositiveNumber.of(splitStrings);
        return sum(numbers).value();
    }

    private PositiveNumber sum(List<PositiveNumber> numbers) {
        return numbers.stream().reduce((prev, next) -> prev.add(next)).get();
    }
}
