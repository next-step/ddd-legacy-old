package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringAdderTest {

    @Test
    @DisplayName("null일 경우 0 반환")
    public void nullReturns0() {
        // given
        final String expression = null;

        // when
        final int result = StringAdder.calculate(new Expression(expression));

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("빈 문자열(\"\")일 경우 0 반환")
    public void emptyStringReturns0() {
        // given
        final String expression = "";

        // when
        final int result = StringAdder.calculate(new Expression(expression));

        // then
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "1,2", "1:1,1", "2:0,1:0"})
    @DisplayName("기본 구분자를 사용하여 수의 합을 구한다")
    void calculateUsingDefaultSeparators(final String expression) {
        // when
        final int result = StringAdder.calculate(new Expression(expression));

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("수가 음수일 경우 throw RuntimeException")
    void negativeNumber() {
        // given
        final String expression = "1,-2";

        // when
        // then
        assertThrows(RuntimeException.class, () -> {
            StringAdder.calculate(new Expression(expression));
        });
    }

    @Test
    @DisplayName("잘못된 구분자를 사용한 경우 throw RuntimeException")
    void wrongFormmatedExpression() {
        // given
        final String expression = "1/2";

        // when
        // then
        assertThrows(RuntimeException.class, () -> {
            StringAdder.calculate(new Expression(expression));
        });
    }
}
