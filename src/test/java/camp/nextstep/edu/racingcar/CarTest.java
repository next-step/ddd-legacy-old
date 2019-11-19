package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @DisplayName("차를 생성한다.")
    @Test
    void create() {
        // when
        final Car car = new Car("a".repeat(CarName.MAX_LENGTH));

        // then
        assertThat(car).isNotNull();
    }

    @DisplayName("자동차 이름은 " + CarName.MAX_LENGTH + " 글자를 넘을 수 없다.")
    @Test
    void create_greaterThanMaxNameLength() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("a".repeat(CarName.MAX_LENGTH + 1)));
    }
}