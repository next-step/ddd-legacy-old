package camp.nextstep.edu.calculator;

import java.util.List;

public class AdditionCalculator {
    public int execute(final String input) {
        return sum(Extractor.getNumbers(input));
    }

    private int sum(final List<Integer> values) {
        return values.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
