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
    void create() {
        final Car car = new Car("Car", 1);
    }

    @DisplayName("자동차 이름은 5글자를 넘을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"내차완전멋지죠"})
    void expectIllegalArgumentExceptionWhenCarNameSizeIsOver5Characters(final String carName) {
        assertThatThrownBy(() -> {
            new Car(carName, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 null이 아니어야 한다.")
    @Test
    void expectIllegalArgumentExceptionWhenCarNameIsNull() {
        assertThatThrownBy(() -> {
            new Car(null, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차가 움직인 경우, position이 1만큼 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void expectMoveCarWhenRandomNumberOverFour(final int position) {

        Car car = new Car("car", 0);
        car.move(() -> true);
        assertThat(car.isInPosition(position)).isTrue();
    }
}