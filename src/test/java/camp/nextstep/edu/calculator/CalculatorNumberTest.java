package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

}
