package camp.nextstep.edu.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName(value = "자동차 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"james", "car"})
    public void createSuccess(String name) {
        Car c =  new Car(name, 1);
    }

    @DisplayName(value = "자동차 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"daehee"})
    public void createFailure(final String name) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(name, 1);
                });
    }

    @DisplayName(value = "자동차 위치 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 100, 10000})
    void isInPosition(final int position) {
        Car car = new Car("name", position);
        assertThat(car.isInPosition(position)).isTrue();
    }

    @Test
    void move() {
        Car car = new Car("name", 0);
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