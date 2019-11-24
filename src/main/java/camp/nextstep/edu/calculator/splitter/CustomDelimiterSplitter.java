package camp.nextstep.edu.calculator.splitter;

import camp.nextstep.edu.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterSplitter implements Splitter {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    @Override
    public boolean supports(String stringValue) {
        if (StringUtils.isBlank(stringValue)) {
            return false;
        }
        return CUSTOM_DELIMITER_PATTERN.matcher(stringValue).matches();
    }

    @Override
    public String[] split(String stringValue) {
        final Matcher matcher = createSplitMatcher(stringValue);

        final String delimiter = matcher.group(1);
        final String values = matcher.group(2);
        return values.split(Pattern.quote(delimiter));
    }

    private Matcher createSplitMatcher(String stringValue) {
        final String errorMessage = "지원하지 않는 형식의 값입니다. stringValue : [" + stringValue + "]";
        if (StringUtils.isBlank(stringValue)) {
            throw new IllegalArgumentException(errorMessage);
        }

        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(stringValue);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(errorMessage);
        }
        return matcher;
    }
}
