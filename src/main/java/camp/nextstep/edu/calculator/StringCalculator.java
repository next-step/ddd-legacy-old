package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern CUSTOM_TOKEN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_TOKEN = "[,:]";

    public int add(String text) {
        if (!isEmpty(text)) {
            return sum(text);
        }
        return 0;
    }

    private int sum(String text) {
        return Arrays
                .stream(splitNumberByToken(text))
                .mapToInt(Integer::parseInt).filter(this::checkNegativeNumber)
                .sum();
    }

    private String[] splitNumberByToken(String text) {
        Matcher matcher = CUSTOM_TOKEN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_TOKEN);
    }

    private boolean checkNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        return true;
    }

    private boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}


