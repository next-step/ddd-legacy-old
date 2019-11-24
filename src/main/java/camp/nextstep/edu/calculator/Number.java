package camp.nextstep.edu.calculator;

public class Number {

    private static final String ZERO = "0";

    private int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number of(String input) {
        int number = Integer.parseInt(input);
        validatePositiveNumber(number);

        return new Number(number);
    }

    public static Number zero() {
        return Number.of(ZERO);
    }

    private static void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("문자열 계산기에 음수 사용은 불가합니다.");
        }
    }

    public int toInt() {
        return number;
    }

    public Number add(Number input) {
        return new Number(this.number + input.number);
    }
}
