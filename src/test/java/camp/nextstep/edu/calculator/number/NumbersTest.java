package camp.nextstep.edu.calculator.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @DisplayName("sumValue - 모든 값의 합을 반환한다.")
    @ParameterizedTest
    @MethodSource(value = "sumValueArguments")
    void sumValue(List<Number> inputNumbers, int expectedValue) throws Exception {
        Numbers numbers = new Numbers(inputNumbers);

        assertThat(numbers.sumValue()).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> sumValueArguments() {
        return Stream.of(
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(Arrays.asList(new Number(0)), 0),
                Arguments.of(Arrays.asList(new Number(1)), 1),
                Arguments.of(Arrays.asList(new Number(1), new Number(3)), 4),
                Arguments.of(Arrays.asList(new Number(1), new Number(3), new Number(4)), 8)
        );
    }

    @DisplayName("parse - 입력받은 문자열 배열을 Numbers 객체로 변환한다.")
    @Test
    void parse() throws Exception {
        Numbers expectedNumbers = new Numbers(
                new Number(1), new Number(3), new Number(2), new Number(4)
        );

        String[] stringNumbers = {"1", "3", "2", "4"};

        Numbers result = Numbers.parse(stringNumbers);

        assertThat(result).isEqualTo(expectedNumbers);
    }

    @DisplayName("parse - 입력받은 배열이 null 이거나 빈 배열이면 EMPTY_NUMBERS 가 반환된다.")
    @ParameterizedTest
    @NullAndEmptySource
    void parseEmptyString(String[] emptyStringNumbers) throws Exception {
        Numbers numbers = Numbers.parse(emptyStringNumbers);

        assertThat(numbers).isSameAs(Numbers.EMPTY_NUMBERS);
        assertThat(numbers.sumValue()).isEqualTo(0);
    }

}
