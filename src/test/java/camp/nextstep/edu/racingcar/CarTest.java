package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 생성")
    @Test
    void create() throws Exception {
        Car car = new Car("name", 1);
    }

    @DisplayName("자동차 생성 - 이름 글자수가 5글자를 넘으면 에러")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567"})
    void checkNameLength(String name) throws Exception {
        assertThat(name.length()).isGreaterThan(Car.CAR_NAME_LENGTH);

        assertThatThrownBy(() -> new Car(name, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("move - MovingStrategy 의 반환값이 true 이면 이동한다.")
    @Test
    void move() throws Exception {
        final int initialPosition = 1;
        Car car = new Car("name", initialPosition);

        TestMovingStrategy movingStrategy = new TestMovingStrategy(true);
        assertThat(movingStrategy.movable()).isTrue();

        car.move(movingStrategy);

        assertThat(car.isInPosition(initialPosition + 1)).isTrue();
    }

    @DisplayName("move - MovingStrategy 의 반환값이 false 이면 이동하지 않는다.")
    @Test
    void move_not() throws Exception {
        final int initialPosition = 1;
        Car car = new Car("name", initialPosition);

        TestMovingStrategy movingStrategy = new TestMovingStrategy(false);
        assertThat(movingStrategy.movable()).isFalse();

        car.move(movingStrategy);

        assertThat(car.isInPosition(initialPosition)).isTrue();
    }

    private static class TestMovingStrategy implements MovingStrategy {

        private final boolean movable;

        private TestMovingStrategy(boolean movable) {
            this.movable = movable;
        }

        @Override
        public boolean movable() {
            return movable;
        }
    }
}