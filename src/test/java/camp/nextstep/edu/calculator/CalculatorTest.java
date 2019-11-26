package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void before() {
        calculator = new Calculator();
    }

    @DisplayName("빈문자열, null 입력")
    @ParameterizedTest
    @NullAndEmptySource
    public void testCalcSum(String input) {
        assertThat(calculator.sum(input), is(0));
    }

    @DisplayName("구분자(, :) 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3" })
    public void testCalcSum1(String input) {
        assertThat(calculator.sum(input), is(6));
    }

    @DisplayName("공백 포함 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2,    3", "1,:    2:3" })
    public void testCalcSum2(String input) {
        assertThat(calculator.sum(input), is(6));
    }

    @DisplayName("커스텀 구분자 입력 - 1은 구분자 없이 문자열로 붙어있으므로 제외")
    @ParameterizedTest
    @ValueSource(strings = "//;\n1;2;3")
    public void testCalcSum3(String input) {
        assertThat(calculator.sum(input), is(5));
    }

    @DisplayName("음수 입력")
    @ParameterizedTest
    @ValueSource(strings = {"-1, -2,    3" })
    public void testCalcSum4(String input) {
        assertThrows(RuntimeException.class, () -> calculator.sum(input));
    }
}