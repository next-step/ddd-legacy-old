package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("문자열 덧셈 계산기 테스트 코드 클래스")
class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        this.stringCalculator = new StringCalculator();
    }

    @DisplayName("빈 문자열 or null 입력시 0을 반환 한다.")
    @ParameterizedTest
    @MethodSource("blankStrings")
    public void zeroTest(String text) {
        //when
        int result = stringCalculator.calculate(text);

        //then
        assertThat(result).isZero();
    }

    static Stream<String> blankStrings() {
        return Stream.of(null, "", "  ");
    }

    @DisplayName("빈 문자열 or null 외 다른 숫자 문자열 입력시 0을 반환하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "011", "112"})
    public void zeroNotTest(String text) {
        //when
        int result = stringCalculator.calculate(text);

        //then
        assertThat(result).isNotZero();
    }

    @DisplayName("숫자만 입력했을경우 해당 숫자를 반환 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "011", "112"})
    public void onlyNumberParseTest(String text) {
        //when
        int result = stringCalculator.calculate(text);

        //then
        assertThat(result).isEqualTo(Integer.parseInt(text));
    }

    @DisplayName("숫자 사이에 구분자 쉼표(,) 또는 콜론(:)이 있을경우 분리후 숫자의 합을 반환 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1,2,3=6", "1:2=3", "1:2,3:4=10"}, delimiter = '=')
    public void delimiterTest(String input, int expected) {
        //when
        int result = stringCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자로 문자열 분리후 숫자의 합을 반환 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    public void customDelimiterTest(String input) {
        //when
        int result = stringCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자 이외의 값 또는 음수이면 런타임 예외를 발생 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "ㅁㄴㅇㄹ", "asdf"})
    public void validNumberTest(String text) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> stringCalculator.calculate(text));
    }
}