package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @DisplayName("자동차 이름으로 자동차를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "a", "ac", "abc", "abcd", "abcde"})
    void create1(final String name) {
        new Car(name);
    }

    @DisplayName("자동차 이름이 null 일 경우, IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @NullSource
    void create2(final String input) {
        assertThrows(IllegalArgumentException.class, () -> new Car(input));
    }

    @DisplayName("자동차 이름이 5 글자가 넘는 경우, IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef"})
    void create3() {
        assertThrows(IllegalArgumentException.class, () -> new Car("abcdef"));
    }

    @DisplayName("자동차 위치를 확인할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 100, 1000})
    void isInPosition(final int position) {
        final Car car = new Car("abcde", position);
        assertThat(car.isInPosition(position)).isTrue();
    }

    @DisplayName("자동차를 움직일 수 있다.")
    @Test
    void move() {
        final Car car = new Car("abcde", 0);
        car.move(() -> true);
        assertThat(car.isInPosition(1)).isTrue();
    }
}