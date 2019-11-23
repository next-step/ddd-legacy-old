package camp.nextstep.edu.calculator;

public class DefaultStringSplitStrategy extends CustomStringSplitStrategy {
    private static final DefaultStringSplitStrategy INSTANCE = new DefaultStringSplitStrategy();

    DefaultStringSplitStrategy() {
        this(new String[]{":",","});
    }

    private DefaultStringSplitStrategy(String[] splitStrings) {
        super(splitStrings);
    }

    public static StringSplitStrategy getInstance() {
        return INSTANCE;
    }
}
