package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("PositiveNumber 객체에 대한 테스트")
class PositiveNumberTest {
    /**
     *
     * @see <a href="https://github.com/joel-costigliola/assertj-core/issues/508">참고</a>
     */
    @DisplayName("양수로만 PositiveNumber 객체를 만들 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4, 8})
    void create1(int value) {
        // expect
        assertThatCode(() -> new PositiveNumber(value))
                .doesNotThrowAnyException();
    }

    @DisplayName("음수로 PositiveNumber 객체를 만들려고 하면 IllegalArgumentException 예외를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, -3, -4, -8})
    void create2(int value) {
        // expect
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PositiveNumber(value));

    }
}
