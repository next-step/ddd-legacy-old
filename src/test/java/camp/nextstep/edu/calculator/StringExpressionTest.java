package camp.nextstep.edu.calculator;

import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 계산식 테스트")
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

    @DisplayName("string 으로 생성된 표현식에 값이 존재하는지 확인한다.")
    @ValueSource(strings = {"1", "3", "4", "5", "7", "100", "1123"})
    @ParameterizedTest
    void create_contains(final String source) {
        // when
        final Expression expression = StringExpression.of(source);

        // then
        assertThat(expression.contains(source)).isTrue();
    }

    @DisplayName("comma 가 포함된 string 으로 생성한다.")
    @ValueSource(strings = {"1,3", "3,4,5"})
    @ParameterizedTest
    void create_comma(final String source) {
        // when
        final Expression expression = StringExpression.of(source);

        // then
        assertThat(expression).isNotNull();
    }

    @DisplayName("comma 와 colon 이 포함된 string 으로 생성한다.")
    @ValueSource(strings = {"1,3:5", "3,4,5:10,20:30"})
    @ParameterizedTest
    void create_commaWith(final String source) {
        // when
        final Expression expression = StringExpression.of(source);

        // then
        assertThat(expression).isNotNull();
    }

    @DisplayName("comma 와 colon 이 포함된 string 으로 생성된 표현식에 값이 존재하는지 확인한다.")
    @ValueSource(strings = {"1,3:5", "3,4,5:10,20:30"})
    @ParameterizedTest
    void create_commaWith_contains(final String source) {
        // when
        final Expression expression = StringExpression.of(source);
        final String[] expected = source.split("[,:]");

        // then
        Arrays.stream(expected)
                .map(expectedValue -> assertThat(expression.contains(expectedValue)))
                .forEach(AbstractBooleanAssert::isTrue);
    }

    @DisplayName("커스텀한 구분자가 포함된 string 으로 생성한다.")
    @MethodSource("createCustom")
    @ParameterizedTest
    void create_custom(final String source) {
        // when
        final Expression expression = StringExpression.of(source);

        // then
        assertThat(expression).isNotNull();
    }

    private static Stream<Arguments> createCustom() {
        return Stream.of(Arguments.of("//;\n100"),
                Arguments.of("//;\n0"),
                Arguments.of("//;\n100"),
                Arguments.of("//;\n1;2"),
                Arguments.of("//;\n0;1;2;3;4;5"),
                Arguments.of("//q\n8q100"),
                Arguments.of("//!\n100!10!1000!1"));
    }

    @DisplayName("전체 값을 합하여 반환한다.")
    @CsvSource(value = {"0|0", "100|100", "1,2|3", "3,3|6", "0,1,2,3,4,5|15", "8,100|108", "100,10,1000,1|1111",
            "1,2,3:4:5|15", "1:1:1|3"},
            delimiter = '|')
    @ParameterizedTest
    void sumAll(final String source,
                final int rawExpected) {
        // given
        final Expression expression = StringExpression.of(source);

        // when
        final CalculateValue result = expression.sumAll();
        final CalculateValue expected = CalculateValue.of(rawExpected);

        // then
        assertThat(result).isEqualTo(expected);
    }
}