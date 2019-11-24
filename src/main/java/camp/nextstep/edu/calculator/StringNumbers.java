package camp.nextstep.edu.calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbers {

    private List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers create(String[] texts) {
        final List<Number> numbers = Stream.of(texts)
                .map(Number::create)
                .collect(Collectors.toList());
        return new Numbers(numbers);
    }

    public int sum() {
        numbers.stream()
                .map(Number::getNumber)
                .reduce(0, Integer::sum);
    }
}
