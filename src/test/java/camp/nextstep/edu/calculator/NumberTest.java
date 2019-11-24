package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    @DisplayName(value = "Number에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    void negative(String input) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Number.of(input));
    }

    @DisplayName(value = "두 Number의 합을 계산한다")
    @ParameterizedTest
    @CsvSource({"1, 2, 3", "2, 3, 5", "100, 100, 200"})
    void add(String first, String second, String result) {
        Number number = Number.of(first);
        Number another = Number.of(second);

        Number add = number.add(another);
        Number expected = Number.of(result);

        assertThat(add.toInt()).isEqualTo(expected.toInt());
    }
}