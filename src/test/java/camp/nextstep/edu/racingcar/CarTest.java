package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름은 5글자 이하일때 오류없이 생성")
    @ParameterizedTest
    @ValueSource(strings = {"jason", "pobi", "ddd", "five"})
    void create(String name) {
        final Car bora = new Car(name, 1);
    }

    @DisplayName("자동차 이름 5글자 초과시 IllegalException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"andeubora", "overfive", "ddddddd"})
    void createOver5Name(String name) {
        // case1
        assertThatThrownBy(() -> new Car(name, 1)).isInstanceOf(IllegalArgumentException.class);
        // case2
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(name, 1));
    }

    @DisplayName("무작위 값이 4이상일 때 움직일 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moving(int position) {
        Car car = new Car("bora"); // position 0
        car.move(() -> true);
        assertThat(car.isInPosition(position)).isTrue();
    }

    @DisplayName("무작위 값이 4미만일 때 움직일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void stop(int position) {
        Car car = new Car("bora"); // position 0
        car.move(() -> false);
        assertThat(car.isInPosition(position)).isFalse();
    }
}