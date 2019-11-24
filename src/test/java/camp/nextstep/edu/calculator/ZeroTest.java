package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Zero 테스트")
class ZeroTest {

    @DisplayName("Zero에 값을 더하면 입력한 값을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "8", "100"})
    void sum(final String source) {
        // given
        final Number zero = Zero.INSTANCE;
        final Number number = Value.of(source);

        // when
        final Number expected = zero.sum(number);

        // then
        assertThat(number).isEqualTo(expected);
    }

    @DisplayName("intValue 호출 시 int 타입으로 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "8", "100"})
    void intValue(final String source) {
        // given
        final Number number = Value.of(source);
        final int intValue = Integer.parseInt(source);

        // when
        final int expected = number.intValue();

        // then
        assertThat(intValue).isEqualTo(expected);
    }
}