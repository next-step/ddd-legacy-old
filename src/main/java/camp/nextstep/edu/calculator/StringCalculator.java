package camp.nextstep.edu.calculator;

import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.Objects;

public class StringCalculator implements Calculator {

    static final int ZERO = 0;
    static final String SEPARATOR = ",|:";

    @Override
    public int add(String expression) {
        if(Objects.isNull(Strings.trimToNull(expression))){
            return ZERO;
        }
        return Arrays.stream(expression.split(SEPARATOR))
              .mapToInt(Integer::valueOf)
              .sum();
    }
}
