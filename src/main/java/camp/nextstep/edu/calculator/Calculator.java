package camp.nextstep.edu.calculator;

import java.util.Arrays;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public int add(String text) {
        return Arrays.stream(text.split(DEFAULT_DELIMITER))
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
