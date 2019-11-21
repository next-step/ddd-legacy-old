package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.calculator.Expression.DEFAULT_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("빈 문자열 또는 null을 입력 할 경우 0")
    @ParameterizedTest
    @NullAndEmptySource
    void add_whenInputEmptyOrNull_thenZero(String expression) {
        Number result = calculator.add(expression);
        assertThat(result.intValue()).isEqualTo(PositiveNumber.ZERO_VALUE);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "123"})
    void add_whenInputOne(String inputOfNumber) {
        assertThat(calculator.add(inputOfNumber)).isEqualTo(Integer.parseInt(inputOfNumber));
    }

    @DisplayName(DEFAULT_SEPARATOR + "를 구분자로 하여 숫자의 합을 반환")
    @ParameterizedTest
    @CsvSource({
            "'1,2',           3",
            "'1,10,100',    111",
            "'1,10:100',    111",
    })
    void add_whenSeparatorComma(String expression, int expectedResult) {
        assertThat(calculator.add(expression)).isEqualTo(expectedResult);
    }

    @DisplayName("커스텀 구분자를 지정하여 숫자의 합 반환")
    @ParameterizedTest
    @CsvSource({
            "'//;\n1;2;3', 6",
            "'//:\n1:2:3', 6",
            "'///\n1/2/3', 6",
            "'//,\n1,2,3', 6",
    })
    void add_whenSeparatorCustom(String expression, int expectedResult) {
        assertThat(calculator.add(expression)).isEqualTo(expectedResult);
    }

    @DisplayName("음수를 전달하는 경우 exception")
    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "1,-1",
            "1,2:-1"
    })
    void add_thenInputNegative_thenException(String expression) {
        assertThatExceptionOfType(NegativeNumberException.class)
                .isThrownBy(() -> calculator.add(expression));
    }
}