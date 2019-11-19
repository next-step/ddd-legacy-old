package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"jason", "jun", "me"})
    void create(String name) {
        final Car car = new Car(name, 1);
        assertThat(car.isInPosition(1)).isTrue();
    }

    @DisplayName("자동차 위치 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 100, 10000})
    void create(final int position) {
        final Car car = new Car("name", position);
        assertThat(car.isInPosition(position)).isTrue();
    }

    @DisplayName("자동차 이름이 5글자를 넘는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"test123", "sungjun"})
    void createException(String name) {
        assertThatThrownBy(() -> {
            new Car(name, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가짜 객체 생성")
    @Test
    void move() {
        final Car car = new Car("name", 0);
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