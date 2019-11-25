package camp.nextstep.edu.calculator.splitter;

import camp.nextstep.edu.util.StringUtils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterSplitter implements Splitter {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_GROUP = 1;
    private static final int VALUES_GROUP = 2;

    @Override
    public boolean supports(String value) {
        return getMatchedMatcher(value).isPresent();
    }

    @Override
    public String[] split(String value) {
        final Matcher matcher = getMatchedMatcher(value)
                .orElseThrow(() ->new IllegalArgumentException("지원하지 않는 형식의 값입니다. value : [" + value + "]"));

        final String delimiter = matcher.group(DELIMITER_GROUP);
        final String values = matcher.group(VALUES_GROUP);
        return values.split(Pattern.quote(delimiter));
    }

    private Optional<Matcher> getMatchedMatcher(String value) {
        if (StringUtils.isBlank(value)) {
            return Optional.empty();
        }

        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(value);
        if (!matcher.matches()) {
            return Optional.empty();
        }

        return Optional.of(matcher);
    }
}
