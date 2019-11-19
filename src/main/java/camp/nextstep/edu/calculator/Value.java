package camp.nextstep.edu.calculator;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

class Value {

    static final int MIN = 0;

    private static final Map<Integer, Value> CACHE = new WeakHashMap<>();

    static final Value DEFAULT = Value.of(MIN);

    private final int value;

    private Value(final int value) {
        this.value = value;
    }

    static Value of(final String source) {
        if (Guard.isNullOrBlank(source)) {
            return DEFAULT;
        }

        return of(Integer.parseInt(source));
    }

    static Value of(final int source) {
        validate(source);

        return CACHE.computeIfAbsent(source, Value::new);
    }

    private static void validate(final int source) {
        if (source < MIN) {
            throw new InsufficientValueException(source);
        }
    }

    int toInt() {
        return value;
    }

    static Value sum(final Value augend,
                     final Value addend) {
        return of(augend.value + addend.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Value that = (Value) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
