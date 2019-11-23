package camp.nextstep.edu.calculator;

import java.util.Arrays;

public class StringCalculator {

    public int add(String input) {
        if (input == null || input.isEmpty())
            return 0;

        String[] numbers = input.split(",");

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
