package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.racingcar.Car.LENGTH_OF_NAME;
import static camp.nextstep.edu.racingcar.Car.START_POSITION;
import static camp.nextstep.edu.racingcar.RandomMovingStrategy.MOVABLE_CONDITION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @DisplayName("자동차를 생성하는데 성공")
    @ParameterizedTest
    @ValueSource(strings = {"name", "pobi", "car"})
    void initialize(final String name) {
        Car car = Car.of(name);

        assertThat(car).isNotNull();
    }

    @DisplayName("이름이 " + LENGTH_OF_NAME + "글자가 넘는 경우 실패")
    @ParameterizedTest
    @ValueSource(strings = {"carName", "wrongName"})
    void initialize_whenNameLessThanSmall_thenException(final String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.of(name));
    }

    @DisplayName("현재 자동차 위치를 확인한다")
    @Test
    void isInPosition() {
        Car car = Car.of("car");

        assertThat(car.isInPosition(START_POSITION)).isTrue();
    }

    @DisplayName(MOVABLE_CONDITION + "이상일 경우 움직인다")
    @Test
    void move_success() {
        Car car = Car.of("car");

        car.move(() -> true);

        assertThat(car.isInPosition(1)).isTrue();
    }

    @DisplayName(MOVABLE_CONDITION + "미만일 경우 움직이지 않는다")
    @Test
    void move_fail() {
        Car car = Car.of("car");

        car.move(() -> false);

        assertThat(car.isInPosition(0)).isTrue();
    }
}