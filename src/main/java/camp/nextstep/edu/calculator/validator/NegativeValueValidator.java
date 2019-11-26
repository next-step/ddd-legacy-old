package camp.nextstep.edu.calculator.validator;

public class NegativeValueValidator implements ValueValidator {
    private static final NegativeValueValidator validator = new NegativeValueValidator();

    private NegativeValueValidator() {
    }

    public static NegativeValueValidator of() {
        return validator;
    }

    @Override
    public void validate(int val) {
        if (val < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }
}
