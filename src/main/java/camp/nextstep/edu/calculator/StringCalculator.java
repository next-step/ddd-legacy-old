package camp.nextstep.edu.calculator;

import java.util.Arrays;

public class StringCalculator {
    private static final String DELIMITER = "[,:]";

    public int add(String input) {
        if (input == null || input.isEmpty())
            return 0;

        String[] numbers = input.split(DELIMITER);

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
