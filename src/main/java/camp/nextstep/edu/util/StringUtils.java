package camp.nextstep.edu.util;

public final class StringUtils {

    private StringUtils() {}

    public static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

}
