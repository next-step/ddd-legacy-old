package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {
    @DisplayName("빈 문자열 또는 null 값 입력 시, true")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String input) {
        // given
        // when
        // then
        assertThat(StringUtils.isEmpty(input)).isTrue();
    }

    @DisplayName("공백 입력 시, true")
    @Test
    void whiteSpace() {
        // given
        // when
        // then
        assertThat(StringUtils.isEmpty(" ")).isTrue();
    }

    @DisplayName("공백이 아닐 시, false")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "1 1", " a"})
    void general(final String input) {
        // given
        // when
        // then
        assertThat(StringUtils.isEmpty(input)).isFalse();
    }
}
