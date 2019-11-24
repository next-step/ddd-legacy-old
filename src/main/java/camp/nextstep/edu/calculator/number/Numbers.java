package camp.nextstep.edu.calculator.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {

    public static final Numbers EMPTY_NUMBERS = new Numbers();

    private final List<Number> values;

    public Numbers(Number... number) {
        this(Arrays.asList(number));
    }

    public Numbers(List<Number> values) {
        this.values = new ArrayList<>(values);
    }

    public static Numbers parse(String[] stringNumbers) {
        if (isEmptyArray(stringNumbers)) {
            return EMPTY_NUMBERS;
        }
        return new Numbers(convertNumbers(stringNumbers));
    }

    private static boolean isEmptyArray(String[] stringNumbers) {
        return Objects.isNull(stringNumbers) || stringNumbers.length == 0;
    }

    private static List<Number> convertNumbers(String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                .map(Number::parse)
                .collect(Collectors.toList());
    }

    public int sumValue() {
        return this.values.stream()
                .reduce(Number.ZERO, Number::plus)
                .getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers other = (Numbers) o;
        return values.equals(other.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
