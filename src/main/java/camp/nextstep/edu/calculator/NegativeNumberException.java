package camp.nextstep.edu.calculator;

class NegativeNumberException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "숫자는 음수일 수 없습니다. (입력값: %d)";

    NegativeNumberException(int number) {
        super(String.format(ERROR_MESSAGE, number));
    }
}
