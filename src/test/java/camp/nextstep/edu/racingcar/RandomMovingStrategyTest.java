package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomMovingStrategyTest {

    @DisplayName("값이 4이상인 경우 movable = true")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void carMoveIfGeneratedValueIsGreaterThanOrEqualTo4(final int number) {
        final RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy(fixedValueGenerator(number));
        assertEquals(randomMovingStrategy.movable(), number >= 4);
    }

    private ValueGenerator fixedValueGenerator(final int number) {
        return () -> number;
    }
}
