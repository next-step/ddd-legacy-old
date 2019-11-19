package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarTest {
    @Test
    void create() {
        Car car = new Car("pobi");
        assertThat(car).isEqualTo(new Car("pobi"));
    }

    @Test
    void create_over_5_name() {
        assertThatThrownBy(() -> {
            new Car("pobico");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        Car car = new Car("pobi");
        car.move(new RandomMovingStrategy() {
            @Override
            boolean movable() {
                return true;
            }
        });
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stop() {
        Car car = new Car("pobi");
        car.move(new RandomMovingStrategy() {
            @Override
            boolean movable() {
                return false;
            }
        });
        assertThat(car.getPosition()).isEqualTo(0);
    }
}