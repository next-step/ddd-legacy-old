package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.StringSplitStrategy.StringSplitStrategyFactory;
import java.util.List;

public class StringCalculator {


    public long calculateSum(String input) {
        if(input == null || input.isEmpty()){
            return 0L;
        }
        StringSplitStrategy strategy = StringSplitStrategyFactory.getStrategy(input);
        List<String> splitStrings = strategy.apply(input);
        List<PositiveNumber> numbers = PositiveNumber.parseStrings(splitStrings);
        PositiveNumber result = numbers.stream().reduce((prev,next) -> prev.add(next)).get();
        return result.value();
    }
}
