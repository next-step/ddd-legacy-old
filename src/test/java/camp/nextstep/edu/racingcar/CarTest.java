package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 생성")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "jh"})
    void create(String name) {
        Car car = new Car(name, 1);
        assertThat(car.isInPosition(1)).isTrue();
    }


    @DisplayName("자동차 이름은 5글자를 넘을 수 없다")
    @Test
    void create() {
        assertThatThrownBy(() -> new Car("가나다라마바사"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차는 한칸씩 움직인다")
    @Test
    void move() {
        int initPosition = 1;
        Car car = new Car("jh", initPosition);
        car.move(() -> true);

        assertThat(car.isInPosition(initPosition + 1)).isTrue();
    }
}
