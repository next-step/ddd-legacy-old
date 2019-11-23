package camp.nextstep.edu.calculator;

public class CalculatorNumber {
    static final CalculatorNumber ZERO = new CalculatorNumber(0);

    private int value;

    public static CalculatorNumber of(final String number) {
        return new CalculatorNumber(number);
    }

    private CalculatorNumber(final int number) {
        this.value = number;
    }

    private CalculatorNumber(final String number) {
        try {
            this.value = Integer.parseInt(number);
            checkNegativeValue();
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private void checkNegativeValue() {
        if (this.value < 0) {
            throw new RuntimeException();
        }
    }

    public CalculatorNumber add(final CalculatorNumber number) {
        return new CalculatorNumber(this.value + number.value);
    }

    public int toInt() {
        return this.value;
    }
}
