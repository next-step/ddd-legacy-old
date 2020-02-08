package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("계산기 객체에 대한 테스트")
class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("null 또는 빈 문자열을 넘기면 결과값으로 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void calculate1(String str) {
        // when:
        int result = stringCalculator.add(str);
        // then:
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("쉼표 구분자를 가지는 숫자 문자열을 넘기면 각 숫자의 합을 반환한다")
    @ParameterizedTest
    @MethodSource("expressionProviderWithComma")
    void calculate2(String str, int expectedResult) {
        // when:
        int result = stringCalculator.add(str);
        // then:
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> expressionProviderWithComma() {
        return Stream.of(
                Arguments.of("1,2", 3),
                Arguments.of("3,5", 8)
        );
    }

    @DisplayName("콜론 구분자를 가지는 숫자 문자열을 넘기면 각 숫자의 합을 반환한다")
    @ParameterizedTest
    @MethodSource("expressionProviderWithColon")
    void calculate3(String str, int expectedResult) {
        // when:
        int result = stringCalculator.add(str);
        // then:
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> expressionProviderWithColon() {
        return Stream.of(
                Arguments.of("1:2", 3),
                Arguments.of("3:5", 8)
        );
    }

    @DisplayName("쉼표와 콜론 구분자가 혼합된 숫자 문자열을 넘기면 각 숫자의 합을 반환한다")
    @ParameterizedTest
    @MethodSource("expressionProviderWithCommaAndColon")
    void calculate4(String str, int expectedResult) {
        // when:
        int result = stringCalculator.add(str);
        // then:
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> expressionProviderWithCommaAndColon() {
        return Stream.of(
                Arguments.of("1,2:5", 8),
                Arguments.of("3:5,2", 10)
        );
    }

    @DisplayName("커스텀 구분자를 가지는 숫자 문자열을 넘기면 각 숫자의 합을 반환한다")
    @ParameterizedTest
    @MethodSource("expressionProviderWithCustomDelimiter")
    void calculate5(String str, int expectedResult) {
        // when
        int result = stringCalculator.add(str);
        // then:
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> expressionProviderWithCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//@\n5@2@3", 10),
                Arguments.of("//%\n4%2%3", 9),
                Arguments.of("//#\n2#2#3", 7),
                Arguments.of("//!\n1!2!3", 6)
        );
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값을 넘기면 RuntimeException 예외를 반환한다")
    @Test
    void exception1() {
        // expect:
        assertThatThrownBy(() -> stringCalculator.add("a,2,3"))
                .isExactlyInstanceOf(NumberFormatException.class);
    }

    @DisplayName("계산기에 음수를 넘기면 RuntimeException 예외를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "1,2,-3"})
    void exception2(String text) {
        // expect:
        assertThatThrownBy(() -> stringCalculator.add(text))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(PositiveNumber.NOT_ALLOWED_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
    }
}

