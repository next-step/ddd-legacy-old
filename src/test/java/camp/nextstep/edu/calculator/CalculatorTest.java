package camp.nextstep.edu.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

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

    @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 합을 반환한다")
    @Test
    void inputIsTwoNumbers() {
        Assertions.assertThat(calculator.add("1,2"))
                .isEqualTo(3);
    }

    @DisplayName("구분자를 컴마 이외에 콜론을 사용할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"1,5", "2:4", "1,2:3"})
    void commaAndColonAsDelimiter(String input) {
        Assertions.assertThat(calculator.add(input))
                .isEqualTo(6);
    }
}