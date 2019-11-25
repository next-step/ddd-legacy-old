package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by inbonk on 2019/11/25.
 */
class StringCalculatorTest {

    @DisplayName("입력이 null 이면 결과는 0이다")
    @Test
    void nullInput() {
        assertThat(new StringCalculator().calculate(null)).isEqualTo(0);
    }

    @DisplayName("숫자가 없으면 결과는 0이다")
    @ParameterizedTest
    @ValueSource(strings = {"", ",:"})
    void empty(String text) {
        assertThat(new StringCalculator().calculate(text)).isEqualTo(0);
    }

    @DisplayName("구분자를 구분해서 계산한다")
    @Test
    void calculate() {
        assertThat(new StringCalculator().calculate("1,2")).isEqualTo(3);
        assertThat(new StringCalculator().calculate("1,2,3")).isEqualTo(6);
        assertThat(new StringCalculator().calculate("1,2:3")).isEqualTo(6);
    }

    @DisplayName("별도의 구분자도 넣을 수 있다, 정규표현식문자도 포함해서")
    @ParameterizedTest
    @ValueSource(strings = {"//A\n12A3", "//.\n11.3.1", "//]\n1]4]6]4", "//{\n9{6"})
    void customDelimiter(String text) {
        assertThat(new StringCalculator().calculate(text)).isEqualTo(15);
    }

    @DisplayName("숫자가 아닌 문자열이 있으면 계산불가")
    @ParameterizedTest
    @ValueSource(strings = {"Q", "A,B", "C:D:E"})
    void nonNumber(String text) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new StringCalculator().calculate(text));
    }
}
