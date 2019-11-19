package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차 생성")
    void create() {

        //given
        //when
        Car car = new Car("자동차");

        //then
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("자동차 이름 5글자 이상일때 Exception 확")
    void car_name_illegalArgumentException_test() {

        assertThatThrownBy(() -> {
            new Car("자동차테스트");
        }).isInstanceOf(IllegalArgumentException.class);

    }


    @DisplayName("자동차 위치 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 100, 1000})
    void isInPosition_test(final int position) {

        //given
        Car car = new Car("자동차", position);

        //when
        boolean isPosition = car.isInPosition(position);

        //then
        assertThat(isPosition).isTrue();
    }

    @Test
    void move_test() {

        //given
        Car car = new Car("name", 0);
        MovingStrategy movingStrategy = new MockMovingStrategy();

        //when
        car.move(movingStrategy);

        //then
        assertThat(car.isInPosition(1)).isTrue();
    }


    class MockMovingStrategy implements MovingStrategy{

        @Override
        public boolean movable() {
            return true;
        }
    }
}