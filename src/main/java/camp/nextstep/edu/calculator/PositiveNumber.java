package camp.nextstep.edu.calculator;

public class PositiveNumber {

    static final int ZERO_VALUE = 0;
    static final PositiveNumber ZERO = new PositiveNumber(ZERO_VALUE);
    private int number;

    private PositiveNumber(int number) {
        this.number = number;
    }

    public static PositiveNumber of(String inputOfNumber) {
        int number = Integer.parseInt(inputOfNumber);
        validateNegativeNumber(number);
        return new PositiveNumber(number);
    }

    private static void validateNegativeNumber(int number) {
        if (number < ZERO_VALUE) {
            throw new NegativeNumberException(number);
        }
    }

    int parseInt() {
        return number;
    }

    PositiveNumber add(PositiveNumber number) {
        return new PositiveNumber(this.number + number.number);
    }
}
