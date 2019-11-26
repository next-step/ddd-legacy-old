package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

class NumberParserTest {

    @DisplayName("커스텀 구분자 추출")
    @ParameterizedTest
    @ValueSource(strings = "//;\n1;2;3")
    public void extractCustomDelimiter(String input) {
        assertThat(NumberParser.getCustomDelimiter(input), is(";"));
    }

    @DisplayName("커스텀 구분자 추출 x")
    @ParameterizedTest
    @ValueSource(strings = "/;1;2;3")
    public void extractCustomDelimiter2(String input) {
        assertNull(NumberParser.getCustomDelimiter(input));
    }
}