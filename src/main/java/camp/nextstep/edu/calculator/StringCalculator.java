package camp.nextstep.edu.calculator;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int calculate(final String text) {
        if (Strings.isBlank(text)) {
            return Number.ZERO_VALUE;
        }
        String[] separatedText = Delimiter.separate(text);
        return sum(separatedText);
    }

    private int sum(final String[] separatedText) {
        List<Number> numbers = new ArrayList<>();
        for (String text : separatedText) {
            numbers.add(Number.intValueOf(text));
        }
        return numbers.stream()
                      .mapToInt(Number::getValue)
                      .sum();
    }
}
