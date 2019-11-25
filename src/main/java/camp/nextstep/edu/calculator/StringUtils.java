package camp.nextstep.edu.calculator;

public class StringUtils {
    public static boolean isEmpty(final String value) {
        if (value == null || value.isEmpty() || value.trim().length() == 0) {
            return true;
        }
        return false;
    }
}
