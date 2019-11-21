package camp.nextstep.edu.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("빈 문자열이 입력될 경우 0을 반환한다")
    @Test
    void inputIsEmpty() {
        Assertions.assertThat(calculator.add(""))
                .isEqualTo(0);
    }

    @DisplayName("null이 입력될 경우 0을 반환한다")
    @Test
    void inputIsNull() {
        Assertions.assertThat(calculator.add(null))
                .isEqualTo(0);
    }

    @DisplayName("숫자 하나를 입력할 경우 해당 숫자를 반환한다")
    @Test
    void inputIsOneNumber() {
        Assertions.assertThat(calculator.add("1"))
                .isEqualTo(1);
    }
}