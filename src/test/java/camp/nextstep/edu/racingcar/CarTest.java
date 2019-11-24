package camp.nextstep.edu.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@TestMethodOrder(value = OrderAnnotation.class)
class CarTest {

    private static final String DEFAULT_NAME = "Car";
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVED_POSITION = 1;

    @Order(1)
    @DisplayName("자동차 정상 생성")
    @ParameterizedTest(name = "{index} => Create successful car name ''{0}''")
    @ValueSource(strings = {"one", "two", "three", "four", "five", "six"})
    void testCreateCar(String name) {
        new Car(name, DEFAULT_POSITION);
    }

    @Order(2)
    @DisplayName("자동차 명 길이 제한으로 생성 실패")
    @ParameterizedTest(name = "{index} => Create fail car name ''{0}''")
    @ValueSource(strings = {"overflow", "exceed"})
    void testCarNameOverException(String name) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new Car(name, DEFAULT_POSITION));
    }

    @Order(3)
    @DisplayName("자동차 정상 움직임")
    @ParameterizedTest
    @MethodSource("getCar")
    void testCarMoveComplete(Car c) {
        c.move(() -> true);
        Assertions.assertThat(c.isInPosition(DEFAULT_POSITION)).isFalse();
    }

    @Order(4)
    @DisplayName("자동차가 움직이지 않음")
    @ParameterizedTest
    @MethodSource("getCar")
    void testCarMoveFail(Car c) {
        c.move(() -> false);
        Assertions.assertThat(c.isInPosition(DEFAULT_POSITION)).isTrue();
    }

    private static Stream<Arguments> getCar() {
        return Stream.of(Arguments.of(new Car(DEFAULT_NAME, DEFAULT_POSITION)));
    }
}
