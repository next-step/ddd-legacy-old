package camp.nextstep.edu.calculator.splitter;

import camp.nextstep.edu.util.NullAndEmptyAndWhiteSpaceStringSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultSplitterTest {

    private DefaultSplitter defaultSplitter = new DefaultSplitter();

    @DisplayName("supports - 항상 true 를 반환한다.")
    @ParameterizedTest
    @MethodSource("supportsArguments")
    void supports(String value) throws Exception {
        assertThat(defaultSplitter.supports(value)).isTrue();
    }

    private static Stream<Arguments> supportsArguments() {
        return Stream.of(
                Arguments.of(new Object[]{null}),
                Arguments.of(""),
                Arguments.of("143")
        );
    }

    @DisplayName("split - 콜론(:) 또는 콤마(,) 를 구분자로 문자열을 나눈다")
    @ParameterizedTest(name = "{displayName} (value : [{0}] / expected : {1})")
    @MethodSource("splitArguments")
    void split(String value, String[] expectedResult) throws Exception {
        final String[] result = defaultSplitter.split(value);

        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> splitArguments() {
        return Stream.of(
                Arguments.of("1,2,3", new String[]{"1", "2", "3"}),
                Arguments.of("1:2:3", new String[]{"1", "2", "3"}),
                Arguments.of("1,2:3", new String[]{"1", "2", "3"}),
                Arguments.of("1:2,3", new String[]{"1", "2", "3"}),
                Arguments.of("1=:2,3", new String[]{"1=", "2", "3"})
        );
    }

    @DisplayName("split - 값이 null 이거나 공백문자이면 빈 배열이 반환된다.")
    @ParameterizedTest(name = "{displayName} (value : [{0}])")
    @NullAndEmptyAndWhiteSpaceStringSource
    void splitEmptyValue(String value) throws Exception {
        final String[] result = defaultSplitter.split(value);

        assertThat(result).isEmpty();
    }

    @DisplayName("split - 값이 하나면 값이 하나인 배열이 반환된다.")
    @Test
    void splitOnlyOneValue() throws Exception {
        String onlyOneValue = "545";
        String[] expectedResult = {onlyOneValue};

        final String[] result = defaultSplitter.split(onlyOneValue);

        assertThat(result).hasSize(1);
        assertThat(result).isEqualTo(expectedResult);
    }
}
