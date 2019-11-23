package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface StringSplitStrategy {
    List<String> apply(String input);

    default String[] escapeCharacters(String[] inputList) {
        return Arrays.stream(inputList).map(Pattern::quote).toArray(String[]::new);
    }
    class StringSplitStrategyFactory {

        public static StringSplitStrategy getStrategy(String input) {
            Matcher matcher = CustomStringSplitStrategy.CUSTOM_SPLIT_REGEX.matcher(input);
            if (matcher.matches()) {
                return new CustomStringSplitStrategy(matcher.group(0));
            }
            return DefaultStringSplitStrategy.getInstance();
        }
    }

}
