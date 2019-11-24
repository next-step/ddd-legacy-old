package camp.nextstep.edu.calculator;

final class Value {

    static Number of(final String source) {
        if (Guard.isNullOrBlank(source) || Zero.INSTANCE.equalsBy(source)) {
            return Zero.INSTANCE;
        }

        return Positive.of(source);
    }
}
