package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.thymeleaf.util.StringUtils;

public class CustomStringSplitStrategy implements StringSplitStrategy {
    private final Pattern splitRegex;

    public CustomStringSplitStrategy(String... splitStrings) {
        if(null == splitStrings ||splitStrings.length == 0){
            throw new IllegalArgumentException("splitStrings must be not empty");
        }
        //escape
        String[] escaped = escapeCharacters(splitStrings);
        String splitRegex = StringUtils.join(escaped, "|");
        this.splitRegex = Pattern.compile(splitRegex);
    }

    private String[] escapeCharacters(String[] inputList) {
        return Arrays.stream(inputList).map(Pattern::quote).toArray(String[]::new);
    }


    @Override
    public List<String> apply(String input) {
        return Arrays.asList(splitRegex.split(input));
    }
}
