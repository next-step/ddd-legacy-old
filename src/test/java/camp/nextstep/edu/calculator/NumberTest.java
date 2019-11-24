package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NumberTest {

    @DisplayName(value = "양수로 생성시 정상 값을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3 ,4 })
    void positiveNumber(final int parameterNumber) {

        Number number = new Number(parameterNumber);

        int reult = number.getNumber();

        assertThat(reult).isEqualTo(parameterNumber);
    }

    @DisplayName(value = "음수로 생성시 Exception이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = { -1, -2, -3 , -4 })
    void negativeNumber(final int parameterNumber) {

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Number(parameterNumber));

    }
}