package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PositiveOrZeroNumberTest {
    @DisplayName("숫자 하나 입력 시, 해당 숫자 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100, 2000})
    void returnInputValue(final int input) {
        // given
        // when
        // then
        assertThat(PositiveOrZeroNumber.of(input)).isEqualTo(PositiveOrZeroNumber.of(input));
    }

    @DisplayName("음수 입력 시, RuntimeException 예외 처리 ")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void invalidInput(final int input) {
        // given
        // when
        // then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> PositiveOrZeroNumber.of(input));
    }
}
