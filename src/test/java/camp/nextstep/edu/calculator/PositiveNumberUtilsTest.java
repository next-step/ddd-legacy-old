package camp.nextstep.edu.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberUtilsTest {

    @DisplayName("parsePositiveInt: 양수 문자를 Interger로 변환")
    @ParameterizedTest
    @ValueSource(strings = {
        "0",
        "1",
        "100"
    })
    void parsePositiveInt(String source) {
        assertThat(PositiveNumberUtils.parsePositiveInt(source)).isInstanceOf(Integer.class);
    }

    @DisplayName("parsePositiveInt: empty 일 때 NumberFormatException 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyParsePositiveInt(String source) {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> PositiveNumberUtils.parsePositiveInt(source));
    }

    @DisplayName("parsePositiveInt: 양의 정수가 아닐 때 NumberFormatException 반환")
    @ParameterizedTest
    @ValueSource(strings = {
        "a",
        "*",
        "-1"
    })
    void invalidParsePositiveInt(String source) {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> PositiveNumberUtils.parsePositiveInt(source));
    }
}