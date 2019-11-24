package camp.nextstep.edu.calculator;

public class StringCalculator {

    public int add(final String text) {
        final String[] result = StringNumberParser.parse(text);
        final StringNumbers numbers = StringNumbers.create(result);
        return numbers.sum();
    }
}
