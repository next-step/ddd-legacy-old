package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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
}