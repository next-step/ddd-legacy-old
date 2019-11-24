package camp.nextstep.edu.calculator;

final class InvalidPositiveException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "%d 보다 작을 수 없습니다. (입력 값: %d)";

    InvalidPositiveException(final int source) {
        super(String.format(ERROR_MESSAGE, Positive.MIN, source));
    }
}
