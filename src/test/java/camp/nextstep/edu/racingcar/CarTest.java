package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @DisplayName("자동차 생성")
    @Test
    void create() {
        new Car("정원", 1);
    }

    @DisplayName("자동차 이름 5자 넘지 않는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "bbbb", "cccc"})
    void testValidCarName(String carName) {
        new Car(carName);
    }

    @DisplayName("자동차 이름 5자 넘는 테스트")
    @Test
    void testInvalidCarName() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("abcdef"));
    }

    @DisplayName("자동차가 움직이지 않는 테스트")
    @Test
    void notMove() {
        Car car = new Car("정원", 0);
        car.move(() -> false);
        assertThat(car.isInPosition(0)).isTrue();
    }

    @DisplayName("자동차가 움직이는 테스트")
    @Test
    void move() {
        Car car = new Car("정원", 0);
        car.move(() -> true);
        assertThat(car.isInPosition(1)).isTrue();
    }

}
