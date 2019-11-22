package camp.nextstep.edu.calculator;

import camp.nextstep.edu.util.NullAndEmptyAndWhiteSpaceStringSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("음수를 입력하면 에러")
    @Test
    void createNegative() throws Exception {
        int negativeValue = -1;

        assertThatThrownBy(() -> new Number(negativeValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("value 는 음수 일 수 없습니다. value = [-1]");
    }

    @DisplayName("parse - 문자열 숫자를 변환한다.")
    @Test
    void parse() throws Exception {
        int value = 12451;

        Number number = Number.parse(String.valueOf(value));

        assertThat(number.getValue()).isEqualTo(value);
    }

    @DisplayName("parse - 빈 문자열을 입력하면 Number.ZERO 가 반환된다.")
    @ParameterizedTest(name = "{displayName} (value : [{0}])")
    @NullAndEmptyAndWhiteSpaceStringSource
    void parseEmptyString(String value) throws Exception {
        Number number = Number.parse(value);

        assertThat(number).isSameAs(Number.ZERO);
    }

    @DisplayName("plus - 두 Number 의 value 를 더한 새로운 객체가 반환된다.")
    @Test
    void plus() throws Exception {
        Number one = new Number(1);
        Number two = new Number(2);

        Number result = one.plus(two);

        assertThat(result).isNotEqualTo(one);
        assertThat(result.getValue()).isEqualTo(3);
    }
}
