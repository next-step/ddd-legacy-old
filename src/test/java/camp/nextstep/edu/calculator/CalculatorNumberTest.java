package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorNumberTest {

    @DisplayName("CalculatorNumber 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void create(final String text) {
        CalculatorNumber.of(text);
    }

    @DisplayName("CalculatorNumber 생성 실패: 음수")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    void negativeValueCreate(final String text) {
        assertThatThrownBy(() -> CalculatorNumber.of(text) )
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("CalculatorNumber 생성 실패: 숫자 이외의 값")
    @ParameterizedTest
    @ValueSource(strings = {"가", "나", "다"})
    void nonNumberFormatValueCreate(final String text) {
        assertThatThrownBy(() -> CalculatorNumber.of(text) )
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> addCase() {
        return Stream.of(
                Arguments.of("1", CalculatorNumber.of("2")),
                Arguments.of("3", CalculatorNumber.of("4")),
                Arguments.of("5", CalculatorNumber.of("6"))
        );
    }

    @DisplayName("CalculatorNumber 더하기")
    @ParameterizedTest
    @MethodSource("addCase")
    void add(final String text, final CalculatorNumber expected) {
        assertThat(CalculatorNumber.of(text).add(CalculatorNumber.of("1"))).isEqualTo(expected);
    }
}
