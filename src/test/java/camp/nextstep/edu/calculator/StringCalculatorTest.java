package camp.nextstep.edu.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringCalculatorTest {
    @ParameterizedTest
    @MethodSource("camp.nextstep.edu.calculator.StringCalculatorTestProvider#defaultStrategy")
    void calculate(String testString, int expected) {
        //when

        StringSplitStrategy defaultStringSplitStrategy = new DefaultStringSplitStrategy();
        StringCalculator calculator = new StringCalculator(defaultStringSplitStrategy);
        PositiveNumber result = calculator.calculateSum(testString);
        //then
        assertThat(result.isSame(PositiveNumber.parse(expected))).isTrue();
    }



    private static class StringCalculatorTestProvider {
        static Stream<Arguments> defaultStrategy(){
            return Stream.of(
                arguments("1,2", 3),
                arguments("1:2", 3),
                arguments("1,2:3", 6)
            );
        }

    }


}