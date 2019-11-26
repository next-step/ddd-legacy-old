package camp.nextstep.edu.calculator;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

public class Calculator {

    public int sum(String input) {
        if (StringUtils.isEmpty(input)) {
            return 0;
        }

        List<Number> nums = NumberParser.parse(input);
        if (CollectionUtils.isEmpty(nums)) {
            return 0;
        }

        return nums.stream()
                .reduce(0, (result, num) -> result + num.getValue(), Integer::sum);
    }
}
