package camp.nextstep.edu.calculator;

final class InvalidArgumentException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "입력 값이 올바르지 않습니다. (입력 값: '%s')";

    InvalidArgumentException(final String source) {
        super(String.format(ERROR_MESSAGE, source));
    }
}
