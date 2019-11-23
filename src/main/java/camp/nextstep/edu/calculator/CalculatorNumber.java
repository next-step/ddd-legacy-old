package camp.nextstep.edu.calculator;

public class CalculatorNumber {
    private int value;

    public static CalculatorNumber of(final String number) {
        return new CalculatorNumber(number);
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
}
