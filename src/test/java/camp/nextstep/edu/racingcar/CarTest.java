package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {

    @DisplayName("자동차 생성")
    @Test
    void create(){
        final Car car = new Car("seha", 1);
    }

    @DisplayName("자동차 이름이 5글자 이하일경우 예외없이 car객체가 생성되어야한다")
    @ParameterizedTest
    @ValueSource(strings = {"seha", "name", "1234", "0000"})
    void under5LengthCarname(String carName) {
        final Car car = new Car(carName, 1);
        assertThat(car.isInPosition(1)).isTrue();
    }

    @DisplayName("자동차 이름이 5글자 초과일경우 IllegalArgumentException이 발생해야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"sehajyang", "zzzzzzzz", "123456", "      "})
    void over5LengthCarname(String carName) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car(carName, 1);
        });
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자일경우 IllegalArgumentException이 발생해야한다")
    void emptyCarname() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("", 1));

    }

    @Test
    @DisplayName("자동차 이름이 null 일경우 IllegalArgumentException이 발생해야한다")
    void nullCarname() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(null, 1));
        }
    }


    @ParameterizedTest
    void move() {
        Car car = new Car("name", 0);
        car.move(new TestMovingStrategy());
        assertThat(car.isInPosition(1)).isTrue();
        }
    }

