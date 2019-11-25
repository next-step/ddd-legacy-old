package camp.nextstep.edu.calculator;

public class StringNumber {

    private static int ZERO = 0;

    private int item;

    private StringNumber(int item) {
        this.validate(item);
        this.item = item;
    }

    private void validate(int item) {
        if(this.isNegative(item))
            throw  new IllegalArgumentException();
    }

    private boolean isNegative(int number) {
        return number < ZERO;
    }

    public static StringNumber create(String text) {
        final int item = Integer.parseInt(text);
        return new StringNumber(item);
    }

    public int getItem() {
        return item;
    }
}
