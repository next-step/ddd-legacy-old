package camp.nextstep.edu.calculator;

public class StringCalculator {
    private static Numbers numbers = new Numbers();

    public StringCalculator() {
        this.numbers = new Numbers();
    }

    public static int add(final String text) {
        return numbers.add(text).toSumInt();
    }
}
