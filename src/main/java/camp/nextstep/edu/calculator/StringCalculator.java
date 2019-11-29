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
        Numbers numbers = Numbers.intValuesOf(separatedText);
        return numbers.sum()
                      .getValue();
    }
}
