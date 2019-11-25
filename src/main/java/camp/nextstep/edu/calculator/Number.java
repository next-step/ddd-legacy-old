package camp.nextstep.edu.calculator;

public class Number {

    private int number;

    private static final int MIN_NUMBER = 0;

    private Number(int number) {
        if (number < MIN_NUMBER) {
            throw new RuntimeException();
        }

        this.number = number;
    }

    private Number(String text) {
        this(Integer.parseInt(text));
    }

    public Number add(Number number) {
        this.number += number.getNumber();

        return this;
    }

    public int getNumber() {
        return number;
    }

    public static Number of(int number) {
        return new Number(number);
    }

    public static Number of(String text) {
        return new Number(text);
    }
}