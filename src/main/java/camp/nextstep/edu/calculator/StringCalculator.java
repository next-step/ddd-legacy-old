package camp.nextstep.edu.calculator;

public class StringCalculator {

    final StringNumberParser numberParser;

    public StringCalculator() {
        this.numberParser = new StringNumberParser();
    }

    public int add(final String text) {
        final String[] result = numberParser.parse(text);
        final StringNumbers numbers = StringNumbers.create(result);
        return numbers.sum();
    }
}
