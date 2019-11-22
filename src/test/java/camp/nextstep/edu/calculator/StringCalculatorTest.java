package camp.nextstep.edu.calculator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void emptyCase(String source) {
        assertThat(calculator.calc(source)).isEqualTo(0);
    }

    private static Stream<Arguments> defaultCase() {
        return Stream.of(
            Arguments.of("1", 1),
            Arguments.of("1,2", 3),
            Arguments.of("1,2,3", 6),
            Arguments.of("1;2", 3),
            Arguments.of("1;2;3", 6),
            Arguments.of("1,2;3", 6),
            Arguments.of("1;2,3", 6),
            Arguments.of("1;2,3;4,5", 15)
        );
    }

    @MethodSource("defaultCase")
    @DisplayName("기본 구분자(',',';') 를 통한 합산")
    @ParameterizedTest
    void defaultSum(String source, int expected) {
        assertThat(calculator.calc(source)).isEqualTo(expected);
    }

    private static Stream<Arguments> customCase() {
        return Stream.of(
            Arguments.of("//;\\n1", 1),
            Arguments.of("//;\\n1;2", 3),
            Arguments.of("//;\\n1;2;3", 6),
            Arguments.of("//|\\n1", 1),
            Arguments.of("//|\\n1|2", 3),
            Arguments.of("//|\\n1|2|3", 6)
        );
    }

    @MethodSource("customCase")
    @DisplayName("커스텀 구분자를 통한 합산")
    @ParameterizedTest
    void customSum(String source, int expected) {
        assertThat(calculator.calc(source)).isEqualTo(expected);
    }

    @DisplayName("구분자를 통해 제공된 양의 정수가 아닐 때 RunTImeException 예외를 반환")
    @ParameterizedTest
    @ValueSource(strings = {
        "a","*","-1",
        "//;\\n1;a;3",
        "1;a;3",
        "1,a;3",
        "1;a;3",
    })
    void invalidChar(String source) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> calculator.calc(source));
    }
}