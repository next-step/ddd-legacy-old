package camp.nextstep.edu.calculator;

import java.util.Objects;

final class Guard {

    private Guard() {
    }

    static boolean isNullOrBlank(final String value) {
        return Objects.isNull(value) || value.isBlank();
    }
}
