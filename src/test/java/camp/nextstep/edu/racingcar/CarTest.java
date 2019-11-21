package camp.nextstep.edu.racingcar;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("자동차 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234", "12345"})
    void create_correct(final String name) {

        final Car car = new Car(name, 1);
        assertThat(car.isInPosition(1)).isTrue();
    }

    @DisplayName("자동차 생성 실패")
    @ParameterizedTest
    @MethodSource("getWrongCarName")
    void create_wrong(final String name) {
        Assertions.assertThatThrownBy(() -> {
            final Car car = new Car(name, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<String> getWrongCarName() {
        return Stream.of("123456", "1234567", null);
    }

    @DisplayName("자동차 위치 설정")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, Integer.MIN_VALUE, Integer.MAX_VALUE})
    void isInPosition(final int position) {
        final Car car = new Car("name", position);
        assertThat(car.isInPosition(position)).isTrue();
    }

    @DisplayName("자동차 이동 유무")
    @Test
    void move() {
        final Car car = new Car("name", 0);
        car.move(new AlwaysTrueMovingStrategy());
        assertThat(car.isInPosition(1)).isTrue();
    }

    class AlwaysTrueMovingStrategy implements MovingStrategy {

        @Override
        public boolean movable() {
            return true;
        }
    }
}