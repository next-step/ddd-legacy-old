package camp.nextstep.edu.racingcar;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

  @DisplayName("자동차 생성")
  @ParameterizedTest
  @ValueSource(strings = {"ryan", "jake", "paul", "abcde"})
  void create(final String name) {

    final Car car = new Car(name, 1);
    assertThat(car.isInPosition(1)).isTrue();
  }

  @DisplayName("자동차 위치 설정")
  @ParameterizedTest
  @ValueSource(ints = {1,2,3,4,100,1020})
  void isInPosition(final int position) {
    final Car car = new Car("name", position);
    assertThat(car.isInPosition(position)).isTrue();
  }

  @DisplayName("자동차 이동 유무")
  @Test
  void move() {
    final Car car = new Car("name", 0);
    car.move(new TestMovingStrategy());
    assertThat(car.isInPosition(1)).isTrue();
  }

  class TestMovingStrategy extends RandomMovingStrategy {
    @Override
    public boolean movable(){
      return true;
    }
  }
}