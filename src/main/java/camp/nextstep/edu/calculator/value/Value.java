package camp.nextstep.edu.calculator.value;

import camp.nextstep.edu.calculator.Guard;

public final class Value {

    private Value() {
    }

    public static Number of(final String source) {
        if (Guard.isNullOrBlank(source) || Zero.INSTANCE.equalsBy(source)) {
            return Zero.INSTANCE;
        }

        return Positive.of(source);
    }
}
