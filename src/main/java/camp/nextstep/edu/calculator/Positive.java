package camp.nextstep.edu.calculator;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

class Positive {

    static final int MIN = 0;

    private static final Map<Integer, Positive> CACHE = new WeakHashMap<>();

    static final Positive DEFAULT = Positive.of(MIN);

    private final int value;

    private Positive(final int value) {
        this.value = value;
    }

    static Positive of(final String source) {
        if (Guard.isNullOrBlank(source)) {
            return DEFAULT;
        }

        return of(Integer.parseInt(source));
    }

    static Positive of(final int source) {
        validate(source);

        return CACHE.computeIfAbsent(source, Positive::new);
    }

    private static void validate(final int source) {
        if (source < MIN) {
            throw new NegativeValueException(source);
        }
    }

    int toInt() {
        return value;
    }

    static Positive sum(final Positive augend,
                        final Positive addend) {
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

        final Positive that = (Positive) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Positive{" +
                "value=" + value +
                '}';
    }
}
