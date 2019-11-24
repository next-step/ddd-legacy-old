package camp.nextstep.edu.calculator;

import java.util.Objects;

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

    private void validateValueIsPositive(final int value) {
        if (this.isNegative(value)) {
            throw new IllegalArgumentException("PositiveNumber must be positive");
        }
    }

    private boolean isNegative(final int value) {
        return (value < 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
