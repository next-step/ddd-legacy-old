package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.exception.NegativeNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("기본 문자열 계산기 [,:]")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6", "5,3,2=10", "2:3:4=9", "0:0,0=0"}, delimiter = '=')
    void 기본_문자열_계산기(String text, Integer expected) {
        assertThat(calculator.add(text)).isEqualTo(expected);
    }

    @DisplayName("커스텀 문자열 계산기")
    @ParameterizedTest
    @MethodSource
    void 커스텀_문자열_계산기(String text, Integer expected) {
        assertThat(calculator.add(text)).isEqualTo(expected);
    }

    private static Stream<Arguments> 커스텀_문자열_계산기() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//&\n4&3&2", 9),
                Arguments.of("//#\n2#4#8", 14)
        );
    }

    @DisplayName("문자열 계산기 음수일 때 NegativeNumberException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2:3", "1:5,-9", "//;\n-1;2;3"})
    void 기본_문자열_음수(String text) {
        assertThatThrownBy(() -> calculator.add(text))
                .isInstanceOf(NegativeNumberException.class);
    }

    @DisplayName("빈 문자열 또는 null일 경우 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_또는_null일경우_0을_반환한다(String text) {
        assertThat(calculator.add(text)).isEqualTo(Calculator.DEFAULT_ZERO_VALUE);
    }

}
