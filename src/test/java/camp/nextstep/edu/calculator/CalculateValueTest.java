package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("정수 테스트")
class CalculateValueTest {

    @DisplayName("string 으로 생성한다.")
    @ValueSource(strings = {"1", "3", "4", "5", "7", "100", "1123"})
    @ParameterizedTest
    void create_string(final String source) {
        // when
        final CalculateValue calculateValue = CalculateValue.of(source);

        // then
        assertThat(calculateValue).isNotNull();
    }

    @DisplayName("integer 로 생성한다.")
    @ValueSource(ints = {1, 3, 4, 5, 7, 100, 1123})
    @ParameterizedTest
    void create_integer(final int source) {
        // when
        final CalculateValue calculateValue = CalculateValue.of(source);

        // then
        assertThat(calculateValue).isNotNull();
    }

    @DisplayName("빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void create_nullAndEmpty(final String source) {
        // when
        final CalculateValue calculateValue = CalculateValue.of(source);

        // then
        assertThat(calculateValue).isEqualTo(CalculateValue.DEFAULT);
    }

    @DisplayName("int 타입으로 변환한다.")
    @ValueSource(ints = {1, 3, 4, 5, 7, 100, 1123})
    @ParameterizedTest
    void toInt(final int source) {
        // given
        final CalculateValue calculateValue = CalculateValue.of(source);

        // when
        final int result = calculateValue.toInt();

        // then
        assertThat(result).isEqualTo(source);
    }

    @DisplayName("같은 두 값을 더하면 2배가 된다.")
    @ValueSource(ints = {1, 3, 4, 5, 7, 100, 1123})
    @ParameterizedTest
    void sum(final int source) {
        // given
        final CalculateValue augend = CalculateValue.of(source);
        final CalculateValue addend = CalculateValue.of(source);

        // when
        final CalculateValue result = augend.sum(addend);
        final CalculateValue expected = CalculateValue.of(source * 2);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("음수를 입력하면 예외처리 한다.")
    @ValueSource(ints = {-1, -100, -123})
    @ParameterizedTest
    void negative(final int source) {
        assertThatExceptionOfType(NegativeValueException.class)
                .isThrownBy(() -> CalculateValue.of(source));
    }

    @DisplayName("원시 값이 같다면 동일한 객체이다.")
    @ValueSource(ints = {1, 3, 4, 5, 7, 100, 1123})
    @ParameterizedTest
    void equals(final int source) {
        // given
        final CalculateValue first = CalculateValue.of(source);
        final CalculateValue second = CalculateValue.of(source);

        // when
        final boolean isEquals = first == second;

        // then
        assertThat(isEquals).isTrue();
    }
}