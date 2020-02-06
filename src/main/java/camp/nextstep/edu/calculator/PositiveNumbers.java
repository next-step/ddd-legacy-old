package camp.nextstep.edu.calculator;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.calculator.CalculatorConstants.ZERO;

public class PositiveNumbers {
    private List<PositiveNumber> positiveNumbers;

    public PositiveNumbers() {
        this(Collections.emptyList());
    }

    public PositiveNumbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public boolean isEmpty() {
        return positiveNumbers.isEmpty();
    }

    public int size() {
        return positiveNumbers.size();
    }

    public int sum() {
        return positiveNumbers.stream()
                .map(PositiveNumber::toInt)
                .reduce(ZERO, Integer::sum);
    }
}
