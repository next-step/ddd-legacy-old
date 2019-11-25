package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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
    public void emptyOrNullThanReturnZero(final String input) {
        // given
        // when
        // then
        assertThat(calculator.execute(input)).isZero();
    }

    @DisplayName("공백 입력 시, 0 반환")
    @Test
    void whiteSpaceThanReturnZero() {
        // given
        // when
        // then
        assertThat(calculator.execute("   ")).isZero();
    }

    @DisplayName("숫자 하나를 문자열로 입력 시, 해당 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "11", "128", "2000"})
    void returnInputValue(final String input) {
        // given
        // when
        // then
        assertThat(calculator.execute(input)).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("숫자 두 개를 컴마(,) 구분자로 입력 시, 두 숫자의 합 반환")
    @ParameterizedTest
    @CsvSource(value = {"0,2:2", "99,999:1098"}, delimiter = ':')
    void twoNumbersWithComma(final String input, final int expected) {
        // given
        // when
        // then
        assertThat(calculator.execute(input)).isEqualTo(expected);
    }

    @DisplayName("기본 구분자로 입력 시, 숫자의 합 반환")
    @ParameterizedTest
    @CsvSource(value = {"0,1,2|3", "99:999|1098", "1,2:3,4|10"}, delimiter = '|')
    void numbersWithDefaultDelimiter(final String input, final int expected) {
        // given
        // when
        // then
        assertThat(calculator.execute(input)).isEqualTo(expected);
    }

    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자 사용 시, 숫자의 합 반환")
    @ParameterizedTest
    @MethodSource("provideInputUseCustomDelimiter")
    void numbersWithCustomDelimiter(final String input, final int expected) {
        // given
        // when
        // then
        assertThat(calculator.execute(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInputUseCustomDelimiter() {
        return Stream.of(
                Arguments.of("//]\n8", 8),
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//%\n1%2%4", 7),
                Arguments.of("//a\n8a9", 17)
        );
    }
}


