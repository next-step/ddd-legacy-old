package camp.nextstep.edu.calculator.value;

public enum Zero implements Number {

    INSTANCE;

    static final int VALUE = 0;
    static final String STRING_VALUE = "0";

    @Override
    public int intValue() {
        return VALUE;
    }

    @Override
    public Number sum(final Number other) {
        return other;
    }

    public boolean equalsBy(final String source) {
        return STRING_VALUE.equals(source);
    }
}
