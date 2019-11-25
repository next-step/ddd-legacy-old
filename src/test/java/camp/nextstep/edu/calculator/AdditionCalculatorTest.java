package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionCalculatorTest {
    private AdditionCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new AdditionCalculator();
    }

    @DisplayName("빈 문자열 또는 null 값 입력 시, 0 반환")
    @ParameterizedTest
    @NullAndEmptySource
    public void emptyOrNullThanReturnZero(final String input) {
        // given
        // when
        // then
        assertThat(calculator.execute(input)).isZero();
    }

    @DisplayName("공백 입력 시, 0 반환")
    @Test
    void whiteSpaceThanReturnZero() {
        // given
        // when
        // then
        assertThat(calculator.execute("   ")).isZero();
    }

    @DisplayName("숫자 하나를 문자열로 입력 시, 해당 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "11", "128", "2000"})
    void returnInputValue(final String input) {
        // given
        // when
        // then
        assertThat(calculator.execute(input)).isEqualTo(Integer.parseInt(input));
    }
}

