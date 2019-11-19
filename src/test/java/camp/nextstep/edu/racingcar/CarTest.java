package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {
    @DisplayName("자동차 생성")
    @Test
    void create() {
        // given
        // when
        // then
        final Car car = new Car("test");
    }

    @DisplayName("자동차 이름이 5글자 이하일 때 정상적으로 생성되는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void carNameTest(final String name) {
        // given
        // when
        final Car car = new Car(name);

        // then
    }

    @DisplayName("자동차 이름이 5글자 초과일 경우 Exception 발생 테스트")
    @Test
    void overThan5carNameTest() {
        // given
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("123456"));
    }

    @DisplayName("조건이 4 이상인 경우에만 움직이는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true"}, delimiter = ':')
    void name(final int randomValue, final boolean isMove) {
        // given
        final Car car = new Car("test");

        // when
        car.move(() -> {
            if (randomValue >= 4) {
                return true;
            }
            return false;
        });

        // then
        assertThat(car.isInPosition(1)).isEqualTo(isMove);
    }
}