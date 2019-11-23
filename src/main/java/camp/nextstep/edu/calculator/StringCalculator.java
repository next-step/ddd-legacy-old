package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DELIMITER = "[,:]";
    private static final String REGEX = "//(.)\n(.*)";

    public int add(String input) {
        if (input == null || input.isEmpty())
            return 0;


        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);

            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        String[] numbers = input.split(DELIMITER);

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
