package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by inbonk on 2019/11/25.
 */
public class StringCalculator {

    private final static String DEFAULT_DELIMITERS = ",:";
    private final static String CUSTOM_DELIMITER_PATTERN = "^//(.)?\\n";

    int calculate(String text) {
        if (text == null || text.length() == 0) return 0;

        String delimiterPattern = getDelimiter(text);
        String cleanText = text.replaceFirst(CUSTOM_DELIMITER_PATTERN, "");

        return Arrays.stream(cleanText.split(delimiterPattern))
                .mapToInt(this::parse)
                .sum();
    }

    private String getDelimiter(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (!matcher.find()) return "[" + DEFAULT_DELIMITERS + "]";

        if (matcher.groupCount() > 1) {
            throw new RuntimeException("구분자가 많습니다.");
        }

        String customDelimiters = DEFAULT_DELIMITERS + matcher.group(1);

        // 커스텀 구분자가 정규표현식에 사용되는 문자일 때는 Pattern.quote 를 이용해 감싸줘야 함
        return Arrays.stream(customDelimiters.split(""))
                .map(Pattern::quote)
                .collect(Collectors.joining("", "[", "]"));
    }

    private int parse(String text) {
        int num = Integer.parseInt(text);
        if (num < 0) {
            throw new RuntimeException("음수를 포함하고 있습니다.");
        }

        return num;
    }
}
