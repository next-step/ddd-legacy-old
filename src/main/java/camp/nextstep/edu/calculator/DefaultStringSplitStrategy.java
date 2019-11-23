package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DefaultStringSplitStrategy implements StringSplitStrategy {
    private static final DefaultStringSplitStrategy DEFAULT = new DefaultStringSplitStrategy();
    private final Pattern splitRegex = Pattern.compile(":|,");

    private DefaultStringSplitStrategy(){}

    public static DefaultStringSplitStrategy getInstance(){
        return DEFAULT;
    }

    @Override
    public List<String> apply(String input) {
        return Arrays.asList(splitRegex.split(input));
    }
}
