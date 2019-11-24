package camp.nextstep.edu.calculator;

public class StringNumber {

    private int item;

    private StringNumber(int item) {
        this.validate(item);
        this.item = item;
    }

    private void validate(int item) {
        if(NumberHelper.isNegative(item))
            throw  new IllegalArgumentException();
    }

    public static StringNumber create(String text) {
        final int item = Integer.parseInt(text);
        return new StringNumber(item);
    }

    public int getItem() {
        return item;
    }
}
