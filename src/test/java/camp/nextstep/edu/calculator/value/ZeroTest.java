package camp.nextstep.edu.calculator.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Zero 테스트")
class ZeroTest {

    @DisplayName("값을 더하면 입력한 값을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "8", "100"})
    void sum(final String source) {
        // given
        final Number zero = Zero.INSTANCE;
        final Number number = Value.of(source);

        // when
        final Number result = zero.sum(number);

        // then
        assertThat(result).isEqualTo(number);
    }

    @DisplayName("intValue 호출 시 int 타입으로 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "8", "100"})
    void intValue(final String source) {
        // given
        final Number number = Value.of(source);
        final int intValue = Integer.parseInt(source);

        // when
        final int result = number.intValue();

        // then
        assertThat(result).isEqualTo(intValue);
    }
}