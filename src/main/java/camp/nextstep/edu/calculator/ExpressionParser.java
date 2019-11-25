package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {

    private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("[,:]");
    private static final Pattern DETECT_CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*)\n(.*)$");

    private static final int MATCHER_GROUP_INDEX_DELIMITER = 1;
    private static final int MATCHER_GROUP_INDEX_VALUE = 2;

    private Pattern delimiter;
    private List<String> valueList;

    public ExpressionParser(String expression) {

        Matcher matcher = DETECT_CUSTOM_DELIMITER_PATTERN.matcher(expression);
        if (matcher.matches()) {
            delimiter = Pattern.compile(matcher.group(MATCHER_GROUP_INDEX_DELIMITER));
            setNumberValueList(delimiter, matcher.group(MATCHER_GROUP_INDEX_VALUE));
            return;
        }

        delimiter = DEFAULT_DELIMITER_PATTERN;
        setNumberValueList(delimiter, expression);
    }

    private void setNumberValueList(Pattern delimiter, String value) {
        if (value == null || value.isEmpty()) {
            throw new InvalidExpressionException("Values are required");
        }

        List<String> valueList = new ArrayList<>();
        for (String separatedValue : delimiter.split(value)) {
            valueList.add(separatedValue);
        }

        this.valueList = Collections.unmodifiableList(valueList);
    }

    public Pattern getDelimiter() {
        return delimiter;
    }

    public List<String> getValue() {
        return valueList;
    }
}
