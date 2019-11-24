package camp.nextstep.edu.calculator;

public class Number {

    private int number;

    private static final int MIN_NUMBER = 0;

    private Number(String text) {
        int number = Integer.parseInt(text);

        if (number < MIN_NUMBER) {
            throw new RuntimeException();
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Number of(String text) {
        return new Number(text);
    }
}