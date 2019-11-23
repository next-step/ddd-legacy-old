package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.StringSplitStrategy.StringSplitStrategyFactory;
import java.util.List;

public class StringCalculator {

    public long calculateSum(String input) {
        if(input == null || input.isEmpty()){
            return 0L;
        }
        List<String> splitStrings =  StringSplitStrategyFactory.getStrategy(input).apply(input);
        List<PositiveNumber> numbers = PositiveNumber.parseStrings(splitStrings);
        return sum(numbers).value();
    }

    private PositiveNumber sum(List<PositiveNumber> numbers) {
        return numbers.stream().reduce((prev,next) -> prev.add(next)).get();
    }
}
