package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("숫자 도메인 객체 테스트 코드 클래스")
class NumberTest {
    private Number number;

    @DisplayName("Number 객체의 인스턴스를 생성할 수 있다.")
    @Test
    public void intValueOfNumber() {
        // when
        number = Number.intValueOf("1");

        // then
        assertThat(number).isNotNull();
    }

    @DisplayName("숫자 이외의 값 또는 음수이면 런타임 예외를 발생 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "ㅁㄴㅇㄹ", "asdf"})
    public void validNumberTest(String text) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Number.intValueOf(text));
    }

    @DisplayName("Number 인스턴스의 값을 갖고 올 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1", "10,10", "1000,1000"})
    public void getValue(String input, int expected) {
        // given - Number 객체 생성
        Number number = Number.intValueOf(input);

        // when
        int value = number.getValue();

        // then
        assertThat(value).isEqualTo(expected);
    }
}