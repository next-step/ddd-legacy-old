package camp.nextstep.edu.calculator;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

final class CalculateValue {

    static final int MIN = 0;

    private static final Map<Integer, CalculateValue> CACHE = new WeakHashMap<>();

    static final CalculateValue DEFAULT = CalculateValue.of(MIN);

    private final int value;

    private CalculateValue(final int value) {
        this.value = value;
    }

    static CalculateValue of(final String source) {
        if (Guard.isNullOrBlank(source)) {
            return DEFAULT;
        }

        return of(Integer.parseInt(source));
    }

    static CalculateValue of(final int source) {
        validate(source);

        return CACHE.computeIfAbsent(source, CalculateValue::new);
    }

    private static void validate(final int source) {
        if (source < MIN) {
            throw new NegativeValueException(source);
        }
    }

    int toInt() {
        return value;
    }

    CalculateValue sum(final CalculateValue other) {
        return of(value + other.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final CalculateValue that = (CalculateValue) o;
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
