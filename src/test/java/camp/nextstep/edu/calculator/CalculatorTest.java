package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("계산기 객체에 대한 테스트")
class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("빈 문자열을 넘기면 결과값으로 0을 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 빈_문자열을_넘기면_결과값으로_0을_반환한다(String str) {
        // when:
        int result = calculator.add(str);
        // then:
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("쉼표 구분자로 구성된 숫자 문자열을 넘기면 각 숫자의 합을 반환한다")
    @ParameterizedTest
    @MethodSource("expressionProviderWithComma")
    void 쉼표_구분자로_구성된_숫자_문자열을_넘기면_각_숫자의_합을_반환한다(String str, int expectedResult) {
        // when:
        int result = calculator.add(str);
        // then:
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> expressionProviderWithComma() {
        return Stream.of(
                Arguments.of("1,2", 3),
                Arguments.of("3,5", 8)
        );
    }

    @DisplayName("콜론 구분자로 구성된 숫자 문자열을 넘기면 각 숫자의 합을 반환한다")
    @ParameterizedTest
    @MethodSource("expressionProviderWithColon")
    void 콜론_구분자로_구성된_숫자_문자열을_넘기면_각_숫자의_합을_반환한다(String str, int expectedResult) {
        // when:
        int result = calculator.add(str);
        // then:
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> expressionProviderWithColon() {
        return Stream.of(
                Arguments.of("1:2", 3),
                Arguments.of("3:5", 8)
        );
    }

    @DisplayName("쉼표 콜론 구분자가 혼합된 숫자 문자열을 넘기면 각 숫자의 합을 반환한다")
    @ParameterizedTest
    @MethodSource("expressionProviderWithCommaAndColon")
    void 쉼표_콜론_구분자가_혼합된_숫자_문자열을_넘기면_각_숫자의_합을_반환한다(String str, int expectedResult) {
        // when:
        int result = calculator.add(str);
        // then:
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> expressionProviderWithCommaAndColon() {
        return Stream.of(
                Arguments.of("1,2:5", 8),
                Arguments.of("3:5,2", 10)
        );
    }

    @DisplayName("커스텀 구분자로 구성된 숫자 문자열을 넘기면 각 숫자의 합을 반환한다")
    @ParameterizedTest
    @MethodSource("expressionProviderWithCustomDelimiter")
    void 커스텀_구분자로_구성된_숫자_문자열을_넘기면_각_숫자의_합을_반환한다(String str, int expectedResult) {
        // when
        int result = calculator.add(str);
        // then:
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> expressionProviderWithCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//;\n5;2;3", 10),
                Arguments.of("//;\n4;2;3", 9)
        );
    }

    @DisplayName("계산기에 숫자 이외의 값을 넘기면 NumberFormatException 예외를 반환한다")
    @Test
    void 계산기에_숫자_이외의_값을_넘기면_NumberFormatException_예외를_반환한다() {
        // expect:
        assertThatThrownBy(() -> calculator.add("a,2,3"))
                .isExactlyInstanceOf(NumberFormatException.class);
    }

    @DisplayName("계산기에 음수를 넘기면 IllegalArgumentException 예외를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "1,2,-3"})
    void 계산기에_음수를_넘기면_IllegalArgumentException_예외를_반환한다(String str) {
        // expect:
        assertThatThrownBy(() -> calculator.add(str))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(Calculator.NOT_ALLOWED_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
    }
}

