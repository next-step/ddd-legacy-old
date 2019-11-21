package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PositiveNumberTest {

    @DisplayName("0, 양수를 생성하는데 성공")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10"})
    void initialize(String number) {
        assertThat(PositiveNumber.of(number)).isNotNull();
    }

    @DisplayName(value = "음수를 전달하는 경우 exception")
    @Test
    void initialize_exception() {
        assertThatExceptionOfType(NegativeNumberException.class)
                .isThrownBy(() -> PositiveNumber.of("-1"));
    }
}