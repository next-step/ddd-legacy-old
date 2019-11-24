package camp.nextstep.edu.calculator;

public class NumberHelper {

    private static int ZERO = 0;

    private NumberHelper() {

    }

    public static boolean isNegative(int number) {
        return number < ZERO;
    }
}
