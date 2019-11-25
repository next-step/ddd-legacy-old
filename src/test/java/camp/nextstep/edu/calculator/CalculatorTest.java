package camp.nextstep.edu.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @DisplayName("기본(:|,) 구분자로 문자열을 파싱하여 문자열 숫자의 합을 반환한다")
    @ParameterizedTest
    @MethodSource("defaultStrategy")
    void calculate(String testString, int expected) {
        //when
        Calculator calculator = new Calculator();
        long result = calculator.sum(testString);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("null 또는 빈 문자열일 경우 0 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void calculate_given_null_or_empty_string(String testString) {
        //when
        Calculator calculator = new Calculator();
        long result = calculator.sum(testString);
        //then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("커스텀 구분자로 문자열을 파싱하여 문자열 숫자의 합을 반환한다")
    @ParameterizedTest
    @MethodSource("customStrategy")
    void calculate_given_custom_splitter(String testString, long expected) {
        //when
        Calculator calculator = new Calculator();
        long result = calculator.sum(testString);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자 이외 문자열 또는 음수 문자열이 주어지면 실패한다")
    @ParameterizedTest
    @ValueSource(strings = {
        "a,2",
        "!,2",
        "-100,2",
        "//;\\na;2",
        "//~\\n!:2",
        "//~\\n-100,2"}
    )
    void calculate_given_invalid_number(String testString) {
        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator();
            long result = calculator.sum(testString);
        });
    }

    private static Stream<Arguments> defaultStrategy() {
        return Stream.of(
            arguments("1,2", 3),
            arguments("1:2", 3),
            arguments("1,2:3", 6),
            arguments("1,2:3,", 6)
        );
    }

    private static Stream<Arguments> customStrategy() {
        return Stream.of(
            arguments("//;\n1;2;3", 6L),
            arguments("//|\n1|2|3", 6L),
            arguments("//~\n2~3", 5L),
            arguments("//~\n2~3~", 5L)
        );
    }

}
