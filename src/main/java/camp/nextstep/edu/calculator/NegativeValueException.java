package camp.nextstep.edu.calculator;

final class NegativeValueException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "%d 보다 작을 수 없습니다. (입력 값: %d)";

    NegativeValueException(final int source) {
        super(String.format(ERROR_MESSAGE, CalculateValue.MIN, source));
    }
}
