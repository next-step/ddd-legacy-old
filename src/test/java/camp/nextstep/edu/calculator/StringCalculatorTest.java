package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(result.intValue()).isEqualTo(StringCalculator.ZERO);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "123"})
    void add_whenInputOne(String inputOfNumber) {
        assertThat(calculator.add(inputOfNumber)).isEqualTo(Integer.parseInt(inputOfNumber));
    }
}