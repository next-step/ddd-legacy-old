package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("1. 빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다. (예 : “” => 0, null => 0)")
    @NullAndEmptySource
    @ParameterizedTest
    void calculate_nullAndEmpty(final String source) {
        // when
        final int result = Calculator.calculate(source);

        // then
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "3", "8", "100"})
    @DisplayName("2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)")
    void calculate_singleNumber(final String source) {
        // when
        final int result = Calculator.calculate(source);

        // then
        assertThat(result).isEqualTo(Integer.parseInt(source));
    }


}