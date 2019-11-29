package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("구분자를 통해 문자열 분리 테스트 코드 클래스")
class DelimiterTest {

    @DisplayName("구분자가 없는 문자열은 그대로 반환 된다.")
    @ParameterizedTest
    @CsvSource({"1,1", "12,12", "123123,123123"})
    void returnSameText(String input, String expected) {
        // when
        String[] result = Delimiter.separate(input);

        // then
        assertThat(result[0]).isNotNull().isEqualTo(expected);
    }

    @DisplayName("기본 구분자(,) 를 통해 문자열 분리가 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void separateToDefaultDelimiter_COMMA(String input) {
        // when
        String[] result = Delimiter.separate(input);

        // then
        String[] expectedResult = {"1", "2"};
        assertArrayEquals(result, expectedResult, "comma delimiter separate test success");
    }

    @DisplayName("기본 구분자(:) 를 통해 문자열 분리가 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"1:2"})
    void separateToDefaultDelimiter_COLON(String input) {
        // when
        String[] result = Delimiter.separate(input);

        // then
        String[] expectedResult = {"1", "2"};
        assertArrayEquals(result, expectedResult, "colon delimiter separate test success");
    }

    @DisplayName("커스텀 구분자로 문자열 분리가 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    public void separateToCustomDelimiter(String input) {
        // when
        String[] result = Delimiter.separate(input);

        // then
        String[] expectedResult = {"1", "2", "3"};
        assertArrayEquals(result, expectedResult, "custom delimiter separate test success");
    }
}