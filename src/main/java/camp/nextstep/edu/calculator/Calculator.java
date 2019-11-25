package camp.nextstep.edu.calculator;

import java.util.List;

public class Calculator {

    public long sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0L;
        }
        List<String> splited = SentenceSplitter.split(input);
        List<PositiveNumber> numbers = PositiveNumber.of(splited);
        return sum(numbers).value();
    }

    private PositiveNumber sum(List<PositiveNumber> numbers) {
        return numbers.stream().reduce(PositiveNumber::add).get();
    }
}
