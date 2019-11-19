package camp.nextstep.edu.calculator;

class InsufficientValueException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "Value 의 값은 %d 보다 작을 수 없습니다. (입력 값: %d)";

    InsufficientValueException(final int source) {
        super(String.format(ERROR_MESSAGE, Value.MIN, source));
    }
}
