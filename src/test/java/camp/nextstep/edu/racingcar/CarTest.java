package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 생성")
    @ParameterizedTest
    @ValueSource(strings = {"MyCar", "four", "you", "hi", "i"})
    void create(String name) {
        Car car = new Car(name, 1);
    }

    @DisplayName("자동차 생성 실패")
    @Test
    void create_fail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           new Car("MyCar2", 1);
        });
    }

    @DisplayName("자동차 위치 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 100, 1000})
    void isInPosition(int position) {
        Car car = new Car("car", position);
        assertThat(car.isInPosition(position)).isTrue();
    }

    @DisplayName("자동차 움직임 확인")
    @Test
    void move() {
        Car car = new Car("car", 0);
        car.move(() -> true);

        assertThat(car.isInPosition(1)).isTrue();
    }

    @DisplayName("자동차 움직이지 않음 확인")
    @Test
    void not_moved() {
        Car car = new Car("car", 0);
        car.move(() -> false);

        assertThat(car.isInPosition(0)).isTrue();
    }
}