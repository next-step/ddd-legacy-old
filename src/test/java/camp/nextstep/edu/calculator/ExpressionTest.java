package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.calculator.Expression.DEFAULT_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {

    @DisplayName(DEFAULT_SEPARATOR + "를 구분자로 하여 숫자를 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1,10,100", "1,10:100"})
    void add_whenSeparatorComma(String expression) {
        Expression result = Expression.of(expression);
        String[] expectedResult = expression.split(DEFAULT_SEPARATOR);

        assertThat(result.getNumbers()).containsExactly(expectedResult);
    }

    @DisplayName("커스텀 구분자를 지정하여 숫자를 반환")
    @ParameterizedTest
    @ValueSource(strings = {
            "//;\n1;2;3",
            "//:\n1:2:3",
            "///\n1/2/3",
            "//,\n1,2,3",
    })
    void add_whenSeparatorCustom(String expression) {
        Expression result = Expression.of(expression);

        assertThat(result.getNumbers()).containsExactly("1", "2", "3");
    }
}