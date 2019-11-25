package camp.nextstep.edu.calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringNumbers {

    private List<StringNumber> items;

    private StringNumbers(List<StringNumber> items) {
        this.items = items;
    }

    public static StringNumbers create(String[] texts) {
        final List<StringNumber> items = Stream.of(texts)
                .map(StringNumber::create)
                .collect(Collectors.toList());
        return new StringNumbers(items);
    }

    public int sum() {
        return items.stream()
                .mapToInt(StringNumber::getItem)
                .sum();
    }
}
