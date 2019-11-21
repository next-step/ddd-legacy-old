package camp.nextstep.edu.calculator;

import java.util.Objects;

public class Calculator {

    public int add(String input) {
        if (isEmptyString(input)) {
            return 0;
        }

        return Integer.parseInt(input);
    }

    private boolean isEmptyString(String str) {
        return Objects.isNull(str) || str.isEmpty();
    }
}
