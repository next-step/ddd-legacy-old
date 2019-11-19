package camp.nextstep.edu.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 이름 5글자 미만 시 생성")
    @ParameterizedTest
    @ValueSource(strings = {"json", "kot", "mei"})
    void createCarLessThan5StringName(String name) {
        Car car = new Car(name, 1);
        assertThat(car).isNotNull();
    }

    @DisplayName("자동차 이름 5글자 이상 시 생성")
    @ParameterizedTest
    @ValueSource(strings = {"jsonjson", "kotkot", "meimei"})
    void createCar5Name(String name) {
        new Car(name, 1);
        Assertions.assertThatIllegalArgumentException();
    }

    @ParameterizedTest
    void move() {
        final Car car = new Car("name", 1);
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