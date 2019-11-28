package camp.nextstep.edu.calculator;

import java.util.Objects;

public class PositiveOrZeroNumber implements Number {
    private static final String NEGATIVE_INPUT_MESSAGES = "음수는 입력하실 수 없습니다.";
    private static final int MIN_VALUE = 0;

    private final int value;

    private PositiveOrZeroNumber(final int value) {
        this.value = validate(value);
    }

    public static Number of(final int value) {
        return new PositiveOrZeroNumber(value);
    }

    private int validate(final int value) {
        if (value < MIN_VALUE) {
            throw new NumberFormatException(NEGATIVE_INPUT_MESSAGES);
        }
        return value;
    }

    @Override
    public int get() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof PositiveOrZeroNumber)) return false;
        final PositiveOrZeroNumber that = (PositiveOrZeroNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
