package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Calculator {
    /**
     * CalculatorTest 에서 {@link Calculator#NOT_ALLOWED_NEGATIVE_NUMBER_EXCEPTION_MESSAGE} 사용하기 위해
     * private 으로 선언하지 않는다.
     */
    static final String NOT_ALLOWED_NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "문자열 계산기에 음수를 전달할 수 없습니다.";
    /**
     * 커스텀 구분자는 문자열 맨 앞의 "//"와 "\n" 사이에 위치 한다.
     */
    private static final String EXPRESSION_WITH_CUSTOM_DELIMITER_REG_EXP = "^//(.)\n(\\S*)$";

    private static final String CUSTOM_DELIMITER_POSITION = "$1";
    private static final String EXPRESSION_POSITION_WITH_CUSTOM_DELIMITER = "$2";

    public int add(String str) {
        if (isEmpty(str)) return 0;

        String expressionWithDelimiter = getExpressionWithDelimiter(str);

        return Arrays.stream(expressionWithDelimiter.split(getDelimiter(str)))
                .mapToInt(this::parsePositiveNumber)
                .sum();
    }

    private boolean isEmpty(String str) {
        return StringUtils.isEmpty(StringUtils.trimWhitespace(str));
    }

    private String getExpressionWithDelimiter(String str) {
        if (hasCustomDelimiter(str)) {
            return extract(str, EXPRESSION_POSITION_WITH_CUSTOM_DELIMITER);
        }
        return str;
    }

    private String getDelimiter(String str) {
        if (hasCustomDelimiter(str)) {
            return extract(str, CUSTOM_DELIMITER_POSITION);
        }
        return ",|:";
    }

    private boolean hasCustomDelimiter(String str) {
        return Pattern.matches(EXPRESSION_WITH_CUSTOM_DELIMITER_REG_EXP, str);
    }

    private String extract(String str, String position) {
        return str.replaceAll(EXPRESSION_WITH_CUSTOM_DELIMITER_REG_EXP, position);
    }

    private int parsePositiveNumber(String s) {
        int number = Integer.parseInt(s);
        if (isNegativeNumber(number)) {
            throw new IllegalArgumentException(NOT_ALLOWED_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
        return number;
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }

}
