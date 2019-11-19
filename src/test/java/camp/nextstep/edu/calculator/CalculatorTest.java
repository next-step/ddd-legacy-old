package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("1. 빈 문자열 또는 null 을 입력할 경우 0을 반환해야 한다. (예 : “” => 0, null => 0)")
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

    @ParameterizedTest
    @CsvSource(value = {"0,1|1", "1,2|3", "3,3|6", "8,100|108", "100,10,1000,1|1111"}, delimiter = '|')
    @DisplayName("3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. (예 : “1,2”)")
    void calculate_comma(final String source,
                         final int expected) {
        // when
        final int result = Calculator.calculate(source);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1|1", "1,2:3|6", "3,3,3:3:3|15"}, delimiter = '|')
    @DisplayName("4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)")
    void calculate_commaWithColon(final String source,
                                  final int expected) {
        // when
        final int result = Calculator.calculate(source);

        // then
        assertThat(result).isEqualTo(expected);
    }
}