package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {
    @DisplayName("Number 하나 입력 시, Numbers 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10, 100, 2000})
    void createBySingleNumber(final int input) {
        // given
        // when
        // then
        final Numbers numbers = new Numbers(PositiveOrZeroNumber.of(input));
    }

    @DisplayName("Numbers 요소 합 구하기")
    @ParameterizedTest
    @MethodSource("provideArrayWithSum")
    void sum(final List<Integer> list, final int expected) {
        // given
        // when
        final Numbers numbers = new Numbers(list.stream()
                .map(PositiveOrZeroNumber::of)
                .collect(Collectors.toList()));

        // then
        assertThat(numbers.sum()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArrayWithSum() {
        return Stream.of(
                Arguments.of(Arrays.asList(0), 0),
                Arguments.of(Arrays.asList(1), 1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 15),
                Arguments.of(Arrays.asList(0, 200), 200)
        );
    }
}
