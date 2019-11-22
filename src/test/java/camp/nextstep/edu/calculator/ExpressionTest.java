package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {

    @Test
    @DisplayName("isEmpty: null일 경우 true")
    void nullIsEmpty() {
        // given
        final String nullExpression = null;

        // when
        final Expression expression = new Expression(nullExpression);

        // then
        assertThat(expression.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("isEmpty: 빈 문자열일 경우 true")
    void emptyStringIsEmpty() {
        // given
        final String emptyExpression = "";

        // when
        final Expression expression = new Expression(emptyExpression);

        // then
        assertThat(expression.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("isEmpty: 빈 문자열이 아닐 경우 true")
    void stringIsNotEmpty() {
        // given
        final String notEmptyExpression = "1,2";

        // when
        final Expression expression = new Expression(notEmptyExpression);

        // then
        assertThat(expression.isEmpty()).isFalse();
    }
}
