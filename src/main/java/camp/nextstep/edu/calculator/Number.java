package camp.nextstep.edu.calculator;

public class Number {
    private int number;

    private Number(String numberString) {
        int number = parseInt(numberString);
        validate(number);
        this.number = number;
    }

    public static Number of(String text) {
        return new Number(text);
    }

    public int value() {
        return number;
    }

    private void validate(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
    }

}
