package camp.nextstep.edu.racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("자동차_이름이_5자가_넘는_경우_IllegalArgumentException_예외발생")
    @Test
    void 자동차_이름이_5자가_넘는_경우_IllegalArgumentException_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car("daeuky", 1));
    }

    @DisplayName("자동차_이름이_5자가_넘지_않는_경우_성공")
    @Test
    void 자동차_이름이_5자가_넘지_않는_경우_성공() {
        final Car car = new Car("car", 1);
    }

    @DisplayName("자동차는_생성될때_입력한_위치에_서있는다")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,10})
    void 자동차는_생성될때_입력한_위치에_서있는다(int position) {
        final Car car = new Car("test", position);
        assertThat(car.isInPosition(position)).isTrue();
    }

    @DisplayName("자동차가_움직일수_있는_경우_다음_위치로_이동한다")
    @Test
    void 자동차가_움직일수_있는_경우_다음_위치로_이동한다() {
        Car car = new Car("Car", 0);
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