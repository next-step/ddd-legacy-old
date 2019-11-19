package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringExpressionTest {

    @DisplayName("빈 문자열 또는 null 을 입력할 경우 NullExpression 을 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void create_nullAndEmpty(final String source) {
        // when
        final Expression expression = StringExpression.of(source);

        // then
        assertThat(expression).isInstanceOf(NullExpression.class);
    }

    @DisplayName("string 으로 생성한다.")
    @ValueSource(strings = {"1", "3", "4", "5", "7", "100", "1123"})
    @ParameterizedTest
    void create_string(final String source) {
        // when
        final Expression expression = StringExpression.of(source);

        // then
        assertThat(expression).isNotNull();
    }

    @DisplayName("comma가 포함된 string 으로 생성한다.")
    @ValueSource(strings = {"1,3", "3,4,5"})
    @ParameterizedTest
    void create_comma(final String source) {
        // when
        final Expression expression = StringExpression.of(source);

        // then
        assertThat(expression).isNotNull();
    }

    @DisplayName("전체 값을 합하여 반환한다.")
    @CsvSource(value = {"0|0", "100|100", "1,2|3", "3,3|6", "0,1,2,3,4,5|15", "8,100|108", "100,10,1000,1|1111"},
            delimiter = '|')
    @ParameterizedTest
    void sumAll(final String source,
                final int rawExpected) {
        // given
        final Expression expression = StringExpression.of(source);

        // when
        final Value result = expression.sumAll();
        final Value expected = Value.of(rawExpected);

        // then
        assertThat(result).isEqualTo(expected);
    }
}