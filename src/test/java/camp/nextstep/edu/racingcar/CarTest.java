package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by inbonk on 2019/11/19.
 */
class CarTest {

    @DisplayName("자동차가 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "1", "12345"})
    void newCarTest(String name) {
        new Car(name, 0);
    }

    @DisplayName("자동차 이름이 없으면 안된다.")
    @Test
    void nullNameCarTest() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Car(null, 0));
    }

    @DisplayName("자동차 이름은 5 글자를 넘을 수 없다.")
    @Test
    void maxLengthOfCarNameTest() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Car("123456", 0));
    }

    @DisplayName("자동차 위치 확인")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
    void carPositionTest(int position) {
        assertThat(new Car("car", position).isInPosition(position)).isTrue();
    }

    @DisplayName("자동차 움직이면 위치가 1 증가한다.")
    @Test
    void carMoveTest() {
        Car car = new Car("car", 0);
        car.move(new TestMovingStrategy());
        assertThat(car.isInPosition(1)).isTrue();
    }

    private static class TestMovingStrategy implements MovingStrategy {

        @Override
        public boolean movable() {
            return true;
        }
    }
}
