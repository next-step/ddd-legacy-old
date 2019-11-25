package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름은 5 글자를 넘을 수 없다")
    @Test
    void 자동차_이름_유효성_체크() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Car("123456", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 4글자 이하는 정상 객체 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234"})
    void 자동차_4자_이하는_객체_정상_생성(final String name) {
        final Car car = new Car(name);

        assertThat(car).isNotNull();
    }

    @DisplayName("무작위 값이 4 이상이면 이동")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_이동(final int move) {
        // given
        final int START_POSITION = 0;
        final Car car = new Car("car", START_POSITION);
        final MovingStrategy movingStrategy = new ManualMovingStrategy(move);

        // when
        car.move(movingStrategy);

        // then
        assertThat(car.isInPosition(START_POSITION + 1))
                .isTrue();
    }

    @DisplayName("무작위 값이 3 이하면 정지")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 자동차_정지(final int move) {
        // given
        final int START_POSITION = 0;
        final Car car = new Car("car", START_POSITION);
        final MovingStrategy movingStrategy = new ManualMovingStrategy(move);

        // when
        car.move(movingStrategy);

        // then
        assertThat(car.isInPosition(START_POSITION))
                .isTrue();
    }
}