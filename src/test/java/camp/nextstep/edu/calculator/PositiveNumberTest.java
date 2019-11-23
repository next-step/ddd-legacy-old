package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositiveNumberTest {

    @Test
    @DisplayName("0은 정상 생성")
    void zeroDoesNotThrowException() {
        // given
        final int zero = 0;

        // when
        // then
        assertDoesNotThrow(() -> {
            new PositiveNumber(zero);
        });
    }

    @Test
    @DisplayName("양수는 정상 생성")
    void positiveDoesNotThrowException() {
        // given
        final int positive = 1;

        // when
        // then
        assertDoesNotThrow(() -> {
            new PositiveNumber(positive);
        });
    }
    @Test
    @DisplayName("음수는 throw IllegalArgumentException")
    void negativeDoesNotThrowException() {
        // given
        final int negative = -1;

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            new PositiveNumber(negative);
        });
    }

    @Test
    @DisplayName("더하기")
    void add() {
        // given
        final int number1 = 1;
        final int number2 = 2;

        final PositiveNumber positiveNumber1 = new PositiveNumber(number1);
        final PositiveNumber positiveNumber2 = new PositiveNumber(number2);

        // when
        final PositiveNumber addResult = positiveNumber1.add(positiveNumber2);

        // then
        assertThat(addResult.isSameValue(number1 + number2)).isTrue();
    }
}