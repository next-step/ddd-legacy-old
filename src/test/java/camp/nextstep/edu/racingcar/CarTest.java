package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "1", "12", "123", "1234", "12345", "123456", "1234567"})
    @DisplayName("자동차 이름은 5글자를 넘지 않아야 한다.")
    void carNameMustBeLessThanOrEqualTo5Characters(final String carName) {
        if (carName.length() > 5) {
            assertThrows(IllegalArgumentException.class, () -> new Car(carName));
            return;
        }
        new Car(carName);
    }

    @Test
    @DisplayName("MovingStrategy.movable() = true의 경우 자동차는 한 칸 움직인다.")
    void carMoveIfMovable() {
        final Car car = new Car("chan", 0);
        car.move(() -> false);
        assertTrue(car.isInPosition(0));

        car.move(() -> true);
        assertTrue(car.isInPosition(1));
    }
}
