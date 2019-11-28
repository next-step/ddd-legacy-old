package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private List<Number> numbers;

    Numbers(final List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    Numbers(final Number number) {
        this(Collections.singletonList(number));
    }

    public int sum() {
        return this.numbers.stream()
                .mapToInt(Number::get)
                .sum();
    }

    @Override
    public String toString() {
        return String.valueOf(this.numbers);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Numbers)) return false;
        final Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
