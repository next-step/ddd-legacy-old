package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Extractor {
    private static final String DEFAULT_DELIMITER = ",|:";

    public static List<Integer> getNumbers(final String input) {
        if (StringUtils.isEmpty(input)) {
            return Collections.singletonList(0);
        }

        final String[] split = input.split(DEFAULT_DELIMITER);

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
