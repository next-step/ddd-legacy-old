package camp.nextstep.edu.calculator;

public class AdditionCalculator {
    public int execute(final String input) {
        if (CustomStringUtils.isEmpty(input)) {
            return 0;
        }
        return Integer.valueOf(input);
    }
}
