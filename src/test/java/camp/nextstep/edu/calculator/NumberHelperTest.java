package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberHelperTest {

    @DisplayName(value = "음수 값을 입력할 경우 true 를 반환해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1})
    void isNegative(final int number) {
        assertThat(NumberHelper.isNegative(number)).isTrue();
    }
}