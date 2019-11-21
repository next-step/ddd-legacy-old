package camp.nextstep.edu.calculator;

import java.util.List;

public class CalNumbers {
    private List<CalNumber> calNumbers;

    public CalNumbers(List<CalNumber> calNumbers) {
        this.calNumbers = calNumbers;
    }

    public int sum() {
        return calNumbers.stream().map(CalNumber::value).reduce(0, (a, b) -> a + b);
    }
}
