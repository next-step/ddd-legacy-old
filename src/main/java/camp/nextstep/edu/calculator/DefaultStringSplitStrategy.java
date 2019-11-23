package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DefaultStringSplitStrategy implements StringSplitStrategy {
    private static final DefaultStringSplitStrategy DEFAULT = new DefaultStringSplitStrategy();
    private static final Pattern DEFAULT_SPLIT_PATTERN = Pattern.compile(":|,");

    private DefaultStringSplitStrategy(){}

    public static DefaultStringSplitStrategy getInstance(){
        return DEFAULT;
    }

    @Override
    public List<String> apply(String input) {
        return Arrays.asList(DEFAULT_SPLIT_PATTERN.split(input));
    }
}
