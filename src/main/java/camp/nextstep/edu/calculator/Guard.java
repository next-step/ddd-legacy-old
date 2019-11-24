package camp.nextstep.edu.calculator;

import java.util.Objects;

public final class Guard {

    private Guard() {
    }

    public static boolean isNullOrBlank(final String value) {
        return Objects.isNull(value) || value.isBlank();
    }
}
