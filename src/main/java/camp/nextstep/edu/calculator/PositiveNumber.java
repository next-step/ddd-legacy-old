package camp.nextstep.edu.calculator;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

public class PositiveNumber {

    private long value;

    public static List<PositiveNumber> of(List<String> inputs) {
        if (CollectionUtils.isEmpty(inputs)) {
            return Collections.emptyList();
        }
        return inputs.stream().map(PositiveNumber::of).collect(toList());
    }

    public static PositiveNumber of(String input) {
        try {
            return new PositiveNumber(Long.parseLong(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("input must be number", e);
        }
    }

    private PositiveNumber(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must be equal or greater than 0");
        }
        this.value = value;
    }

    public PositiveNumber add(PositiveNumber next) {
        Assert.notNull(next, "next must be not null");
        return new PositiveNumber(this.value + next.value);
    }

    public boolean isSame(PositiveNumber other) {
        return other != null && this.value == other.value;
    }

    public long value() {
        return this.value;
    }
}
