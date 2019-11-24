package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1:2"})
    @DisplayName("문자열에서 수를 가져온다")
    void retrieveNumbers(final String expressionString) {
        // given
        final Expression expression = new Expression(expressionString);

        // when
        final List<PositiveNumber> numbers = expression.retrieveNumbers();

        // then
        assertThat(numbers).hasSize(2);
        assertThat(numbers.get(0).isSameValue(1)).isTrue();
        assertThat(numbers.get(1).isSameValue(2)).isTrue();
    }

    @Test
    @DisplayName("수가 음수일 경우 throw RuntimeException")
    void negativeNumber() {
        // given
        final Expression expression = new Expression("1,-2");

        // when
        // then
        assertThrows(RuntimeException.class, () -> {
            expression.retrieveNumbers();
        });
    }

    @Test
    @DisplayName("잘못된 구분자를 사용한 경우 throw RuntimeException")
    void wrongSeparatorExpression() {
        // given
        final Expression expression = new Expression("1/2");

        // when
        // then
        assertThrows(RuntimeException.class, () -> {
            expression.retrieveNumbers();
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"//add\n1add2", "//plus\n1plus2", "//;\n1;2"})
    @DisplayName("custom 구분자를 사용하여 문자열에서 수를 가져온다")
    void retrieveNumbersUsingCustomSeparators(final String expressionString) {
        // given
        final Expression expression = new Expression(expressionString);

        // when
        final List<PositiveNumber> numbers = expression.retrieveNumbers();

        // then
        assertThat(numbers).hasSize(2);
        assertThat(numbers.get(0).isSameValue(1)).isTrue();
        assertThat(numbers.get(1).isSameValue(2)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;1;2", ";\n1;2"})
    @DisplayName("custom 구분자 선언 오류")
    void wrongCustomSeparatorDeclaration(final String expression) {
        // when
        // then
        assertThrows(RuntimeException.class, () -> {
            new Expression(expression);
        });
    }
}
