package camp.nextstep.edu.calculator;

public class Number {
    private int number;

    private Number(String numberString) {
        parseInt(numberString);
        validate(number);
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

    private void parseInt(String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
