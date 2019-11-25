package camp.nextstep.edu.calculator;

public class Number {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    private int value;

    public Number(String text) {
        int number = parse(text);
        if (isNegative(number)) {
            throw new RuntimeException(String.format(Constants.RUNTIME_EXCEPTION_MESSAGE, number));
        }
        this.value += number;
    }

    private int parse(String text) {
        int number = ZERO;
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException(new NumberFormatException(
                    String.format(Constants.NUMBER_FORMAT_EXCEPTION_MESSAGE, number)));
        }
        return number;
    }

    private boolean isNegative(int number) {
        return number < ZERO;
    }

    public int getValue() {
        return this.value;
    }
}
