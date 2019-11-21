package camp.nextstep.edu.calculator;

public class Number {
    private int number;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;

    public Number() {
    }

    public int parse(String text) {
        int number = ZERO;
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException(new NumberFormatException(
                    String.format(Constants.NUMBER_FORMAT_EXCEPTION_MESSAGE, number)));
        }
        return number;
    }

    public void add(String text) {
        int number = parse(text);
        if (isNegative(number)) {
            throw new RuntimeException(
                    String.format(Constants.RUNTIME_EXCEPTION_MESSAGE, number));
        }
        this.number += number;
    }

    public boolean isNegative(int number) {
        return number < ZERO;
    }

    public int getNumber() {
        return this.number;
    }
}
