package camp.nextstep.edu.calculator;

import java.util.Objects;

public class StringUtils {
    public static boolean isEmpty(final String value) {
        return Objects.isNull(value) || value.isEmpty() || value.trim().isEmpty();
    }
}
