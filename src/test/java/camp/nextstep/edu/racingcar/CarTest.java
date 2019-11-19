package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 생성")
    @Test
    void create(){
        final Car car = new Car("seha", 1);
    }

    @DisplayName("자동차 이름이 5글자 이하일경우 예외없이 car객체가 생성되어야한다")
    @Test
    @ParameterizedTest
    @ValueSource(strings = {"seha", "name","1234","0000"})
    void under5LengthCarname(String carName){
        final Car car = new Car(carName, 1);
        assertThat(car.isInPosition(1)).isTrue();
    }

    @DisplayName("자동차 이름이 5글자를 넘을경우 IllegalArgumentException이 발생해야 한다")
    @ParameterizedTest
    @Test
    @ValueSource(strings = {"sehajyang", "zzzzzzzz","12345","0000000"})
    void over5LengthCarname(String carName) {
        Car carName5over = new Car(carName, 1);
        assertThat(carName5over.isInPosition(1)).isTrue();
        assertThatIOException().isThrownBy(() -> {
        });
    }

    @ParameterizedTest
    void move() {
        Car car = new Car("name", 0);
        car.move(new TestMovingStrategy());
        assertThat(car.isInPosition(1)).isTrue();
    }
}