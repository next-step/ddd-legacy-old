package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAdderTest {

    @Test
    @DisplayName("null일 경우 0 반환")
    public void nullReturns0() {
        // given
        final String expression = null;

        // when
        final int result = StringAdder.calculate(expression);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("빈 문자열(\"\")일 경우 0 반환")
    public void emptyStringReturns0() {
        // given
        final String expression = "";

        // when
        final int result = StringAdder.calculate(expression);

        // then
        assertThat(result).isEqualTo(0);
    }
}