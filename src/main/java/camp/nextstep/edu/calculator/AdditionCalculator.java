package camp.nextstep.edu.calculator;

import java.util.Arrays;

public class AdditionCalculator {
    private static final String DEFAULT_DELIMITER = ",";

    public int execute(final String input) {
        if (CustomStringUtils.isEmpty(input)) {
            return 0;
        }

        final String[] split = input.split(DEFAULT_DELIMITER);
        return sum(split);
    }

    private int sum(final String[] split) {
        return Arrays.stream(split)
                .mapToInt(value -> Integer.parseInt(value))
                .sum();
    }
}
