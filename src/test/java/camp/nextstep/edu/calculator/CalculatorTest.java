package camp.nextstep.edu.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("빈 문자열 또는 null이 입력될 경우 0을 반환한다")
    @ParameterizedTest
    @NullSource
    @EmptySource
    void inputIsEmptyOrNull(String input) {
        Assertions.assertThat(calculator.add(input))
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

    @DisplayName("//와 \\\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    void customDelimiter() {
        Assertions.assertThat(calculator.add("//;\n1;2;3"))
                .isEqualTo(6);
    }

    @DisplayName("음수가 입력된 경우는 RuntimeException 발생")
    @Test
    void exceptionWhenNegativeNumber() {
        Assertions.assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    calculator.add("1,2:-3");
                });
    }
}