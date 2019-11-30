package camp.nextstep.edu.calculator;

import java.util.Arrays;

class StringCalculator {
    private static final Integer TEXT_IS_NULL_OR_EMPTY = 0;
    private StringParser parser;
    private Number number;

    StringCalculator() {
        this.parser = new StringParser();
        this.number = new Number();
    }

    int add(String text) {
        try {
            StringValidator.checkFormat(text);
        } catch (IllegalArgumentException e) {
            return TEXT_IS_NULL_OR_EMPTY;
        }

        String[] numbers = parser.toStringArrayFrom(text);

        return Arrays.stream(numbers)
            .mapToInt(number::getPositiveNumber)
            .sum();
    }
}
