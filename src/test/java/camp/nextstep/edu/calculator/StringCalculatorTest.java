package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String text) {
        assertThat(calculator.add(text)).isZero();
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void oneNumber(final String text) {
        assertThat(calculator.add(text)).isSameAs(Integer.parseInt(text));
    }

    @DisplayName("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "2,1"})
    void twoNumbers(final String text) {
        assertThat(calculator.add(text)).isSameAs(3);
    }

    private static Stream<Arguments> defaultDelimiterCase() {
        return Stream.of(
                Arguments.of("1:2,3", 6),
                Arguments.of("4,5:6", 15),
                Arguments.of("7:8:9", 24)
        );
    }

    @DisplayName("구분자를 쉼표(,) 이외에 콜론(:)을 사용")
    @ParameterizedTest
    @MethodSource("defaultDelimiterCase")
    void colons(final String text, final int expected) {
        assertThat(calculator.add(text)).isSameAs(expected);
    }

    private static Stream<Arguments> customDelimiterCase() {
        return Stream.of(
                Arguments.of("//\\;\n1;2;3", 6),
                Arguments.of("//\\|\n4|5|6", 15),
                Arguments.of("//\\*\n7*8*9", 24)
        );
    }

    @DisplayName("//와 \n 문자 사이에 커스텀 구분자 지정")
    @ParameterizedTest
    @MethodSource("customDelimiterCase")
    void customDelimiter(final String text, final int expected) {
        assertThat(calculator.add(text)).isSameAs(expected);
    }

    @DisplayName("음수를 입력할 경우 RuntimeException 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "1,-2", "//;\n1;2;-3"})
    void negativeNumberTest(final String text) {
        assertThatThrownBy(() -> calculator.add(text))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Value must be greater than or equal to zero.");
    }

    @DisplayName("숫자 이외의 값을 입력할 경우 RuntimeException 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a,2,3", "1:b,3", "//;\n1;2;c"})
    void NumberFormatTest(final String text) {
        assertThatThrownBy(() -> calculator.add(text))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Input must be numeric.");
    }
}
