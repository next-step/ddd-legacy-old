package camp.nextstep.edu.calculator;

public class InvalidDelimiterException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "입력 값이 올바르지 않습니다. (입력 값: '%s')";

    InvalidDelimiterException(final String source) {
        super(String.format(ERROR_MESSAGE, source));
    }
}
