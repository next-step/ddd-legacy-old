package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("기본 문자열 계산기 [,:]")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6", "5,3,2=10", "2:3:4=9", "0:0,0=0"}, delimiter = '=')
    void 기본_문자열_계산기(String text, Integer expected) {
        assertThat(calculator.add(text)).isEqualTo(expected);
    }

}
