package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 객체에 대한 테스트")
class CarTest {

    @DisplayName("자동차 이름이 5글자를 넘으면 IllegalArgumentException 예외를 발생한다.")
    @Test
    void 자동차_이름이_5글자를_넘으면_IllegalArgumentException_예외를_발생한다() {
        // expect
        assertThatThrownBy(() -> new Car("서버위저드 차"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 5글자 이하면 자동차를 정상적으로 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"서", "서버위", "서버위저드"})
    void 자동차_이름이_5글자_이하면_자동차를_정상적으로_생성한다(String name) {
        // given
        Car car = new Car(name);
        // expect
        assertThat(car.matchByName(name)).isTrue();
    }

    @DisplayName("자동차의 위치가 4이상인 경우 자동차는 움직인다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void 자동차의_위치가_4이상인_경우_자동차는_움직인다(int position) {
        // given
        Car car = new Car("위저드", position);
        // when
        car.move(new RandomMovingStrategy(new FixedNumberGenerator(position)));
        // then
        assertThat(car.isInPosition(position)).isFalse();
    }

    @DisplayName("자동차의 위치가 4미만인 경우 자동차는 안움직인다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 자동차의_위치가_4미만인_경우_자동차는_안움직인다(int position) {
        // given
        Car car = new Car("위저드", position);
        // when
        car.move(new RandomMovingStrategy(new FixedNumberGenerator(position)));
        // then
        assertThat(car.isInPosition(position)).isTrue();
    }

    @DisplayName("자동차 이름이 null일 경우 IllegalArgumentException 예외를 발생한다")
    @ParameterizedTest
    @NullSource
    void 자동차_이름이_null_일경우_IllegalArgumentException_예외를_발생한다(final String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(name));
    }

    @DisplayName("자동차 이름이 빈 문자열일 경우 IllegalArgumentException 예외를 발생한다")
    @Test
    void 자동차_이름이_빈_문자열_일경우_IllegalArgumentException_예외를_발생한다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(""));
    }
}