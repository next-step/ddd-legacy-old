package camp.nextstep.edu.util;

import java.util.Objects;

public final class StringUtils {

    private StringUtils() {}

    public static boolean isBlank(String value) {
        return Objects.isNull(value) || value.trim().isEmpty();
    }

}
