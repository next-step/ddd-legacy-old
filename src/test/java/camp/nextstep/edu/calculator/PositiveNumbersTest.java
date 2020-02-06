package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PositiveNumbers 일급 객체에 대한 테스트")
class PositiveNumbersTest {

    @DisplayName("디폴트 생성자로 PositiveNumbers 객체를 생성하면, 내부에 빈 List<PositiveNumber>를 가지게 된다")
    @Test
    void create1() {
        // expect
        assertThat(new PositiveNumbers().isEmpty())
                .isTrue();
    }

    @DisplayName("PositiveNumbers 일급 객체의 sum 메소드를 호출하면 내부 List<Number>의 총합을 반환한다")
    @ParameterizedTest
    @MethodSource("positiveNumberProvider")
    void create2(List<PositiveNumber> positiveNumbers, int expectedResult) {
        // expect
        assertThat(new PositiveNumbers(positiveNumbers).sum())
                .isEqualTo(expectedResult);
    }

    static Stream<Arguments> positiveNumberProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(new PositiveNumber(1), new PositiveNumber(2), new PositiveNumber(3)), 6),
                Arguments.of(Arrays.asList(new PositiveNumber(5), new PositiveNumber(2), new PositiveNumber(5)), 12),
                Arguments.of(Arrays.asList(new PositiveNumber(7), new PositiveNumber(2), new PositiveNumber(4)), 13)
        );
    }
}
