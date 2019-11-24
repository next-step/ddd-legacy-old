package camp.nextstep.edu.calculator.exception;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(int value) {
        super("음수는 허용하지 않습니다. value = [" + value + "]");
    }
}
