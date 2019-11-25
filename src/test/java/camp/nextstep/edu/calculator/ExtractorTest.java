package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ExtractorTest {
    @DisplayName("숫자 하나 입력 시, 해당 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "11", "128", "2000"})
    void returnInputValue(final String input) {
        // given
        // when
        // then
        assertThat(Extractor.getNumbers(input))
                .isEqualTo(Arrays.asList(Integer.parseInt(input)));
    }

    @DisplayName("입력한 문자들을 정수 리스트로 반환")
    @ParameterizedTest
    @MethodSource("provideInputWithArray")
    void returnIntList(final String input, final List<Integer> expected) {
        // given
        // when
        // then
        assertThat(Extractor.getNumbers(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInputWithArray() {
        return Stream.of(
                Arguments.of("0,2", Arrays.asList(0, 2)),
                Arguments.of("1,2:3", Arrays.asList(1, 2, 3)),
                Arguments.of("//;\n11;200;3", Arrays.asList(11, 200, 3)),
                Arguments.of("//a\n8a9", Arrays.asList(8, 9))
        );
    }

    @DisplayName("숫자 이외의 값 또는 음수 입력 시, RuntimeException 예외 처리 ")
    @ParameterizedTest
    @ValueSource(strings = {"a", "-1", "!", "0,a", "1,-2:3", "//;\n1;a;3"})
    void invalidInput(final String input) {
        // given
        // when
        // then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Extractor.getNumbers(input));
    }
}
