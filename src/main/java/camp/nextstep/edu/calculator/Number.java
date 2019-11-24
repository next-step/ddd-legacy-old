package camp.nextstep.edu.calculator;

public class Number {

    private final int number;

    public Number(final int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
