package camp.nextstep.edu.calculator;

import static camp.nextstep.edu.calculator.StringCalculator.ZERO;

public class PositiveNumber {
    static final String NOT_ALLOWED_NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수를 전달할 수 없습니다.";
    private int value;

    public PositiveNumber(int value) {
        validatePositiveNumber(value);
        this.value = value;
    }

    private void validatePositiveNumber(int value) {
        if (isNegativeNumber(value)) {
            throw new IllegalArgumentException(NOT_ALLOWED_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNegativeNumber(int number) {
        return number < ZERO;
    }

    int toInt() {
        return this.value;
    }
}
