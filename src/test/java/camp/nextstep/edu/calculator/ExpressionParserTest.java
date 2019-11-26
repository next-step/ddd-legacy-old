package camp.nextstep.edu.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionParserTest {

    @DisplayName("커스텀 구분기호가 입력된 문자열에서 구분기호와 값을 분리한다.")
    @ParameterizedTest
    @MethodSource("customDelimiterExpressionProvider")
    void customDelimiterExpression(String expression, String delimiter, List<String> value) {
        ExpressionParser expressionParser = new ExpressionParser(expression);

        assertThat(expressionParser.getDelimiter().pattern()).isEqualTo(delimiter);
        assertThat(expressionParser.getValue()).isEqualTo(value);
    }

    private static Stream<Arguments> customDelimiterExpressionProvider() {
        return Stream.of(
                Arguments.of("//a\n1a2a3", "a", Arrays.asList("1", "2", "3")),
                Arguments.of("//abc\n1abc2abc3", "abc", Arrays.asList("1", "2", "3"))
        );
    }

    @DisplayName("기본 구분기호가 입력된 문자열에서 값을 분리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1:2,3", "1,2,3", "1:2:3"})
    void defaultDelimiterExpression(String expression) {
        ExpressionParser expressionParser = new ExpressionParser(expression);

        assertThat(expressionParser.getDelimiter().pattern()).isEqualTo("[,:]");
        assertThat(expressionParser.getValue()).isEqualTo(Arrays.asList("1", "2", "3"));
    }

}
