package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.validator.NegativeValueValidator;
import camp.nextstep.edu.calculator.validator.ValueValidator;

import java.util.Collections;
import java.util.List;

public class Number {
    private static final List<ValueValidator> validators = Collections.singletonList(NegativeValueValidator.of());

    private int value;

    public Number(String val) {
        try {
            this.value = Integer.parseInt(val);
        } catch (NumberFormatException e) {
            this.value = 0;
        }

        validators.forEach(valueValidator -> valueValidator.validate(value));
    }

    public int getValue() {
        return value;
    }
}
