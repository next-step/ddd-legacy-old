package camp.nextstep.edu.calculator;

public class PositiveNumber {
    private final int value;

    PositiveNumber(final int value) {
        this.validateValueIsPositive(value);

        this.value = value;
    }

    int getValue() {
        return value;
    }

    PositiveNumber add(final PositiveNumber number) {
        return new PositiveNumber(this.value + number.value);
    }

    boolean isSameValue(final int value) {
        return (this.value == value);
    }

    private void validateValueIsPositive(final int value) {
        if (this.isNegative(value)) {
            throw new IllegalArgumentException("PositiveNumber must be positive");
        }
    }

    private boolean isNegative(final int value) {
        return (value < 0);
    }
}
