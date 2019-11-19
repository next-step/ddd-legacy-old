package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 이름은 최대 5 글자")
    void maxNameLength() {
        // given
        final String name = "abcde";

        // when
        // then
        assertDoesNotThrow(() -> {
            new Car(name);
        });
    }

    @Test
    @DisplayName("자동차 이름 길이의 최댓값인 5를 넘으면 IllegalArgumentException")
    void exceedMaxNameLength() {
        // given
        final String name = "abcdef";

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(name);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10, 1000})
    @DisplayName("Car 생성 시 초기값으로 position이 주어질 경우 Car의 position이 해당 값으로 정해진다.")
    void carPositionInit(final int position) {
        // when
        final Car car = new Car("son", position);

        // then
        assertThat(car.isInPosition(position)).isTrue();
    }

    @Test
    @DisplayName("MovingStrategy가 true를 리턴할 경우 이동한다.")
    void move() {
        // given
        final int initialPosition = 0;
        final Car car = new Car("son", initialPosition);

        final MovingStrategy alwaysMovingStrategy = () -> true;

        // when
        car.move(alwaysMovingStrategy);

        // then
        assertThat(car.isInPosition(initialPosition + 1)).isTrue();
    }

    @Test
    @DisplayName("MovingStrategy가 false를 리턴할 경우 이동하지 않는다.")
    void notMove() {
        // given
        final int initialPosition = 0;
        final Car car = new Car("son", initialPosition);

        final MovingStrategy neverMovingStrategy = () -> false;

        // when
        car.move(neverMovingStrategy);

        // then
        assertThat(car.isInPosition(initialPosition)).isTrue();
    }
}