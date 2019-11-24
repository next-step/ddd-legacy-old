package camp.nextstep.edu.calculator.splitter;

import camp.nextstep.edu.util.StringUtils;

import java.util.regex.Pattern;

class DefaultSplitter implements Splitter {

    private static final String[] EMPTY_ARRAY = {};
    private static final Pattern DELIMITER = Pattern.compile("[,:]");

    @Override
    public boolean supports(String value) {
        return true;
    }

    @Override
    public String[] split(String value) {
        if (StringUtils.isBlank(value)) {
            return EMPTY_ARRAY;
        }
        return DELIMITER.split(value);
    }
}
