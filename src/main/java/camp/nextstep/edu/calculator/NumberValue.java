package camp.nextstep.edu.calculator;

public class NumberValue {

    private int number;

    public NumberValue(String number) {
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }

    public boolean isNegative() {
        return number < 0;
    }
}
