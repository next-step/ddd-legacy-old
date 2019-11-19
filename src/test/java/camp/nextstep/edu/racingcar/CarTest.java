package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    @DisplayName("자동차 생성 - 이름 5자 이하")
    @Test
    public void testCarName() {
        assertThrows(IllegalArgumentException.class, () -> new Car("123456"));
    }

    @DisplayName("자동차 생성 - 이름 5자 이하(입력값)")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567", "jinbro"})
    public void testCarNameByInputValue(String carName) {
        assertThrows(IllegalArgumentException.class, () -> new Car(carName));
    }

    @DisplayName("자동차 이동 테스트 규칙을 테스트")
    @Test
    public void testMovingStrategy() {
        Car car = new Car("jin");
        car.move(() -> true);

        assertTrue(car.isInPosition(1));

        car.move(() -> false);

        assertTrue(car.isInPosition(1));
    }
}