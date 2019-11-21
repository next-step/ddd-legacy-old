package camp.nextstep.edu.calculator;

public class CalNumber{
    private int number;

    public CalNumber(String number) {
        this.number = validate(parseInt(number));
    }

    public int value() {
        return this.number;
    }

    private int validate(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
