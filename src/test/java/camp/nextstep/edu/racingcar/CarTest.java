package camp.nextstep.edu.racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {

    @TestFactory
    @DisplayName("생성 제약")
    Collection<DynamicTest> validateCreate() {
        return Arrays.asList(
            DynamicTest.dynamicTest("5 글자 이하의 자동차 이름을 가질 수 있다.", () ->
                Arrays.asList("", "1", "12", "123", "1234", "12345")
                    .forEach(name ->
                        assertThatCode(() -> new Car(name)).doesNotThrowAnyException()
                    )
            ),
            DynamicTest.dynamicTest("자동차 이름은 5 글자를 넘을 수 없다.", () ->
                Arrays.asList( "123456", "1234567", "1234578", "12345789", "123457890")
                .forEach(name ->
                    assertThatIllegalArgumentException().isThrownBy(() -> new Car(name, 1))
                )
            )
        );
    }

    private static Stream<Arguments> moveCase() {
        return Stream.of(
            Arguments.of(false, 0),
            Arguments.of(true, 1)
        );
    }

    @MethodSource("moveCase")
    @ParameterizedTest
    @DisplayName("자동차는 전략에 의해 움직인다.")
    void move(boolean givenStrategy, int expectedPosition) {
        Car car = new Car("1");
        car.move(() -> givenStrategy);

        assertThat(car.isInPosition(expectedPosition)).isTrue();
    }
}