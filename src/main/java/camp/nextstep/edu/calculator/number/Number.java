package camp.nextstep.edu.calculator.number;

import camp.nextstep.edu.util.StringUtils;

import java.util.Objects;

public class Number {

    public static final Number ZERO = new Number(Number.ZERO_VALUE);
    private static final int ZERO_VALUE = 0;

    private final int value;

    public Number(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (isNegative(value)) {
            throw new IllegalArgumentException("value 는 음수 일 수 없습니다. value = [" + value + "]");
        }
    }

    private boolean isNegative(int value) {
        return value < ZERO_VALUE;
    }

    public static Number parse(String value) {
        if (StringUtils.isBlank(value)) {
            return ZERO;
        }
        return new Number(Integer.parseInt(value.trim()));
    }

    public Number plus(Number number) {
        return new Number(this.value + number.value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                '}';
    }
}
