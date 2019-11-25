package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DefaultSeparator implements Separator {

    @Override
    public CalculateInfo getCalculateInfo(String input) {
        List<String> separatorList = Arrays.stream(DefaultSeparatorType.values()).map(DefaultSeparatorType::getSeparator).collect(toList());
        return CalculateInfo.getInstance(separatorList, input);
    }

    enum DefaultSeparatorType {

        COMMA(","),
        COLON(":");

        DefaultSeparatorType(String separator) {
            this.separator = separator;
        }

        private String separator;

        public String getSeparator() {
            return separator;
        }
    }
}
