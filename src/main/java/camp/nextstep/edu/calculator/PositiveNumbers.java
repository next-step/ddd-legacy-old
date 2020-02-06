package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.calculator.StringCalculator.ZERO;

public class PositiveNumbers {
    private List<PositiveNumber> positiveNumbers;

    public PositiveNumbers() {
        this(Collections.emptyList());
    }

    public PositiveNumbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public static PositiveNumbers of(String[] stringNumbers) {
        List<PositiveNumber> positiveNumbers = Arrays.stream(stringNumbers)
                .map(strNumber -> new PositiveNumber(Integer.parseInt(strNumber)))
                .collect(Collectors.toList());

        return new PositiveNumbers(positiveNumbers);
    }

    public boolean isEmpty() {
        return positiveNumbers.isEmpty();
    }

    public int sum() {
        return positiveNumbers.stream()
                .map(PositiveNumber::toInt)
                .reduce(ZERO, Integer::sum);
    }
}
