package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Number> numbers = new ArrayList<>();

    public Numbers add(String text) {
        Expression expression = Expression.of(text);
        for (String expressionItem : expression.getExpressions()) {
            numbers.add(Number.of(expressionItem));
        }
        return this;
    }

    public int toSumInt() {
        return numbers.stream()
                .map(Number::value)
                .reduce(0, (a, b) -> a + b);
    }

}
