package camp.nextstep.edu.calculator;

import java.util.Arrays;

class StringCalculator {
    private StringParser parser;
    private StringValidator stringValidator;
    private NumberValidator numberValidator;

    StringCalculator(StringParser parser, StringValidator stringValidator, NumberValidator numberValidator) {
        this.parser = parser;
        this.stringValidator = stringValidator;
        this.numberValidator = numberValidator;
    }

    int add(String text) {
        if (!stringValidator.validateFormat(text)) {
            return 0;
        }

        String[] numbers = parser.parse(text);

        return Arrays.stream(numbers)
            .mapToInt(numberValidator::validatePositive)
            .sum();
    }
}
