package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomDelimiterSplitterTest {

    private CustomDelimiterSplitter customDelimiterSplitter = new CustomDelimiterSplitter();

    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자가 있는 형태일때만 true")
    @ParameterizedTest(name = "{displayName}[{index}] - value : [{0}], expected : [{1}]")
    @MethodSource("supportsArguments")
    void supports(String value, boolean expected) throws Exception {
        final boolean result = customDelimiterSplitter.supports(value);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> supportsArguments() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", true),
                Arguments.of("//;\n1", true),
                Arguments.of("//;\n1;", true),
                Arguments.of("//;\n1,", true),
                Arguments.of("\n1,", false),
                Arguments.of("//1,", false)
        );
    }

    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자로 값을 분할한다.")
    @ParameterizedTest(name = "{displayName}[{index}] - value : [{0}], expected : {1}")
    @MethodSource("splitArguments")
    void split(String value, String[] expectedResult) throws Exception {
        final String[] result = customDelimiterSplitter.split(value);

        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> splitArguments() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", new String[] {"1", "2", "3"}),
                Arguments.of("//;\n1", new String[] {"1"}),
                Arguments.of("//;\n1;", new String[] {"1"}),
                Arguments.of("//.\n1.2.3", new String[] {"1", "2", "3"}),
                Arguments.of("//.\n1.2;3", new String[] {"1", "2;3"})
        );
    }

    @DisplayName("형식에 맞지 않는 값은 에러")
    @ParameterizedTest(name = "{displayName}[{index}] - value : [{0}]")
    @MethodSource("splitNotMatchedValueArguments")
    void splitNotMatchedValue(String value) throws Exception {
        assertThatThrownBy(() -> customDelimiterSplitter.split(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> splitNotMatchedValueArguments() {
        return Stream.of(
                Arguments.of("\n1,"),
                Arguments.of("//1,"),
                Arguments.of("1"),
                Arguments.of(new Object[]{ null }),
                Arguments.of(""),
                Arguments.of(" ")
        );
    }
}
