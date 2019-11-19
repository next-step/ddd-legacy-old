package camp.nextstep.edu.racingcar;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("이름이 주어졌을 때 Car 생성")
    @ParameterizedTest
    @ValueSource(strings = {"a", "123", "abc","abced"})
        void create(final String name) {
        //when
        Car car = new Car(name);
        assertThat(car).isNotNull();
    }
    @DisplayName("이름과 위치가 주어졌을 때 Car 생성")
    @Test
    void createWithValidNameAndPosition(){
        //when
        Car car = new Car("abc", 1);
        assertThat(car).isNotNull();
    }

    @DisplayName("Car의 이름은 5자 초과일 수 없다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef"})
    void createWithLongName(final String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Car car = new Car(name);
            });
    }

    @DisplayName("Car의 이름은 null 일 수 없다")
    @ParameterizedTest
    @NullSource
    void createWithNullName(final String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Car car = new Car(name);
            });
    }

    @DisplayName("Car의 현재 위치와 같을 때 isInPosition은 true를 반환한다")
    @Test
    void isInPosition() {
        //given
        Car car = buildCar();
        //when && then
        assertThat(car.isInPosition(0)).isTrue();
        assertThat(car.isInPosition(1)).isFalse();
    }

    @DisplayName("Car의 현재 위치와 다를 때 isInPosition은 false를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 100, -1, Integer.MAX_VALUE, Integer.MIN_VALUE})
    void isInPosition(final int position) {
        //given
        Car car = buildCar();
        //when && then
        assertThat(car.isInPosition(position)).isFalse();
    }

    @DisplayName("movable한 MovingStrategy일 때 1칸 앞으로 움직인다")
    @Test
    void move() {
        //given
        Car car = buildCar();

        MovingStrategy mockStrategy = new MockMovingStrategy(true);
        assertThat(mockStrategy.movable()).isTrue();

        //when
        car.move(mockStrategy);

        //then
        assertThat(car.isInPosition(1)).isTrue();

    }
    @DisplayName("movable하지 않은 MovingStrategy일 때 움직이지 않는다")
    @Test
    void moveGivenStrategyNotMovable() {
        //given
        Car car = buildCar();

        MovingStrategy mockStrategy = new MockMovingStrategy(false);
        assertThat(mockStrategy.movable()).isFalse();

        //when
        car.move(mockStrategy);

        //then
        assertThat(car.isInPosition(0)).isTrue();
    }

    private Car buildCar() {
        return new Car("mia");
    }
}