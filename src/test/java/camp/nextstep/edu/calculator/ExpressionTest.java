package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.calculator.Expression.DEFAULT_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {

    @DisplayName(DEFAULT_SEPARATOR + "를 구분자로 하여 숫자를 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1,10,100", "1,10:100"})
    void add_whenSeparatorComma(String expression) {
        Expression result = Expression.of(expression);

        Integer[] expectedResult = Arrays.stream(expression.split(DEFAULT_SEPARATOR))
                                         .mapToInt(Integer::valueOf)
                                         .boxed()
                                         .toArray(Integer[]::new);

        assertThat(result.getNumbers())
                .extracting(PositiveNumber::parseInt)
                .containsExactly(expectedResult);
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

        assertThat(result.getNumbers())
                .extracting(PositiveNumber::parseInt)
                .containsExactly(1, 2, 3);
    }
}