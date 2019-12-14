package camp.nextstep.edu.calculator.exception;

public class NegativeNumberException extends RuntimeException {

	public NegativeNumberException(int value) {
		super("Negative Number Exception: input value is " + value + ".");
	}
}
