package camp.nextstep.edu.calculator;

public class StringCalculator {
    private Numbers numbers;

    public StringCalculator() {
        this.numbers = new Numbers();
    }

    public static StringCalculator get() {
        return new StringCalculator();
    }

    public int add(String text) {
        Numbers numbers = this.numbers.add(text);
        return numbers.toSumInt();
    }
}
