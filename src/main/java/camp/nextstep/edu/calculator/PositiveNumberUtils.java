package camp.nextstep.edu.calculator;

public class PositiveNumberUtils {
    private PositiveNumberUtils() {
    }

    public static int parsePositiveInt(String s) throws NumberFormatException {
        int i = Integer.parseInt(s);
        if(i < 0) {
            throw new NumberFormatException("It is not positive numbers. string: \"" + s + "\"");
        }
        return i;
    }
}
