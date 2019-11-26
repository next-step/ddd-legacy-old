package camp.nextstep.edu.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValueTest {

    @DisplayName("문자열로 된 숫자값을 입력할 경우 해당 숫자를 반환해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1", "65535", "2147483647"})
    void getNumber(final String number) {
        NumberValue numberValue = new NumberValue(number);
        assertThat(numberValue.getNumber()).isEqualTo(Integer.parseInt(number));
    }

    @DisplayName("문자열로 된 음수값을 입력할 경우 음수여부가 true 이다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-32768", "-2147483648"})
    void isNegative(String number) {
        NumberValue numberValue = new NumberValue(number);
        assertThat(numberValue.isNegative()).isTrue();
    }
}
