package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @DisplayName("자동차 생성")
    @ParameterizedTest
    @ValueSource(strings = {"j", "jko", "jkooo", "jkoooo"})
    void create(final String name) {
        final Car car = new Car(name, 1);
        assertThat(car.isInPosition(1)).isTrue();
    }

    @DisplayName("자동차 위치")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 300, 4444, 55555})
    void isInPosition(final int position) {
        final Car car = new Car("name ", position);
        assertThat(car.isInPosition(position)).isTrue();
    }

    @DisplayName("자동차 움직임")
    @Test
    void moveTest() {
        final Car car = new Car("name ", 0);
        car.move(new TestMovingStrategy());
        assertThat(car.isInPosition(1)).isTrue();
    }


    class TestMovingStrategy implements MovingStrategy {

        @Override
        public boolean movable() {
            return true;
        }
    }

}
