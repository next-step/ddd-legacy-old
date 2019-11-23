package camp.nextstep.edu.calculator;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

public class PositiveNumber {

    private long value;

    public static List<PositiveNumber> parseStrings(List<String> inputList) {
        if (CollectionUtils.isEmpty(inputList)) {
            return Collections.emptyList();
        }
        return inputList.stream().map(PositiveNumber::parse).collect(toList());
    }

    public static PositiveNumber parse(String input) {
        try {
            return new PositiveNumber(Integer.parseInt(input));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("input must be number");
        }
    }

    public static PositiveNumber parse(Integer input) {
        return new PositiveNumber(input.longValue());
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
    public boolean isSame(PositiveNumber other){
        return other != null && this.value == other.value;
    }

    public boolean isSameAs(Integer other){
        return other!=null && this.value == other;
    }

    public long value(){
        return this.value;
    }
}
