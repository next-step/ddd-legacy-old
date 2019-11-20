package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차가 정상 생성된다")
    @Test
    void basic() {
        Car car = new Car("name", 1);
        assertThat(car.isInPosition(1)).isTrue();
    }

    @DisplayName("자동차 이름이 5자 이하이면 정상 생성된다")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"ab", "abc", "abcd", "abcde", " "})
    void carName_lessThanFive(String name) {
        Car car = new Car(name, 1);

        assertThat(car.isInPosition(1)).isTrue();
    }

    @DisplayName("자동차 이름이 5자를 넘으면 Exception을 일으킨다")
    @ParameterizedTest
    @ValueSource(strings = {"aabbcc", "aabbccdd", "aabbccddee"})
    void carName_overFive(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 null이면 Exception을 일으킨다")
    @ParameterizedTest
    @NullSource
    void carName_null(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("MovingStrategy 가 movable 하다면 자동차 위치가 변한다")
    @Test
    void movePosition_movableTrue() {
        Car car = new Car("name", 0);
        car.move(new MovableMovingStrategy());

        assertThat(car.isInPosition(1)).isTrue();
    }

    @DisplayName("MovingStrategy 가 movable 하지 않다면 자동차 위치가 그대로다")
    @Test
    void stayPosition_movableFalse() {
        Car car = new Car("name", 0);
        car.move(new ImmovableMovingStrategy());

        assertThat(car.isInPosition(0)).isTrue();
    }

    class MovableMovingStrategy implements MovingStrategy {
        @Override
        public boolean movable() {
            return true;
        }
    }

    class ImmovableMovingStrategy implements MovingStrategy {
        @Override
        public boolean movable() {
            return false;
        }
    }

}
