package camp.nextstep.edu.calculator.expression;

import camp.nextstep.edu.calculator.InvalidArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("구분자 테스트")
class DelimiterTest {

    @DisplayName("기본 구분자로 구분한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,1", "1,2:3:6", "3,3,3:3:3,15"})
    void delimit(final String source) {
        // when
        final String[] delimited = Delimiter.delimit(source);
        final String[] expected = source.split(Delimiter.DEFAULT_REGEX);

        // then
        assertThat(delimited).isEqualTo(expected);
    }

    @DisplayName("빈 문자열 또는 null 을 입력할 경우 예외처리 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void delimit_nullAndEmpty(final String source) {
        assertThatExceptionOfType(InvalidArgumentException.class)
                .isThrownBy(() -> Delimiter.delimit(source));
    }

    @DisplayName("커스텀한 구분자가 포함된 값을 구분한다.")
    @MethodSource("createCustom")
    @ParameterizedTest
    void delimit_custom(final String source,
                        final String[] expected) {
        // when
        final String[] delimited = Delimiter.delimit(source);

        // then
        assertThat(delimited).isEqualTo(expected);
    }

    private static Stream<Arguments> createCustom() {
        return Stream.of(Arguments.of("//;\n100", new String[]{"100"}),
                Arguments.of("//;\n0", new String[]{"0"}),
                Arguments.of("//;\n100", new String[]{"100"}),
                Arguments.of("//;\n1;2", "1;2".split(";")),
                Arguments.of("//;\n0;1;2;3;4;5", "0;1;2;3;4;5".split(";")),
                Arguments.of("//q\n8q100", "8q100".split("q")),
                Arguments.of("//!\n100!10!1000!1", "100!10!1000!1".split("!")));
    }
}