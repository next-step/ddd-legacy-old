package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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
    public void emptyOrNullThanReturnZero(final String value) {
        // given
        // when
        // then
        assertThat(calculator.execute(value)).isZero();
    }

    @DisplayName("공백 입력 시, 0 반환")
    @Test
    void whiteSpaceThanReturnZero() {
        assertThat(calculator.execute("   ")).isZero();
    }
}
