package camp.nextstep.edu.calculator.value;

import camp.nextstep.edu.calculator.Guard;
import camp.nextstep.edu.calculator.InvalidArgumentException;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

final class Positive implements Number {

    static final int MIN = 1;

    private static final Map<Integer, Positive> CACHE = new WeakHashMap<>();

    private final int value;

    private Positive(final int value) {
        this.value = value;
    }

    static Positive of(final String source) {
        if (Guard.isNullOrBlank(source)) {
            throw new InvalidArgumentException(source);
        }

        return of(Integer.parseInt(source));
    }

    static Positive of(final int source) {
        validate(source);

        return CACHE.computeIfAbsent(source, Positive::new);
    }

    private static void validate(final int source) {
        if (source < MIN) {
            throw new InvalidPositiveException(source);
        }
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public Number sum(final Number other) {
        return of(value + other.intValue());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Positive that = (Positive) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "CalculateValue{" +
                "value=" + value +
                '}';
    }
}
