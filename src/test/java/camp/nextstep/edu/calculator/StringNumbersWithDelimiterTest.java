package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringNumbersWithDelimiterTest {

    @DisplayName("쉼표 또는 콜론 구분자를 가지는 숫자 문자열을 넘기면, 구분자와 구분자를 포함한 숫자 문자열이 필드에 저장된다.")
    @ParameterizedTest
    @MethodSource("expressionProviderWithCommaOrColon")
    void create1(String text, String expectedDelimiter, String expectedStringNumbersWithDelimiter) {
        // given
        StringNumbersWithDelimiter stringNumbersWithDelimiter = StringNumbersWithDelimiter.of(text);

        // expect
        assertThat(ReflectionTestUtils.getField(stringNumbersWithDelimiter, "delimiter"))
                .isEqualTo(expectedDelimiter);
        assertThat(ReflectionTestUtils.getField(stringNumbersWithDelimiter, "stringNumbersWithDelimiter"))
                .isEqualTo(expectedStringNumbersWithDelimiter);
    }

    private static Stream<Arguments> expressionProviderWithCommaOrColon() {
        return Stream.of(
                Arguments.of("1,2,3", StringNumbersWithDelimiter.DEFAULT_DELIMITER, "1,2,3"),
                Arguments.of("3:5:1", StringNumbersWithDelimiter.DEFAULT_DELIMITER, "3:5:1"),
                Arguments.of("7,1:9", StringNumbersWithDelimiter.DEFAULT_DELIMITER, "7,1:9")
        );
    }

    @DisplayName("커스텀 구분자를 가지는 숫자 문자열을 넘기면, 구분자와 구분자를 포함한 숫자 문자열이 필드에 저장된다.")
    @ParameterizedTest
    @MethodSource("expressionProviderWithCustomDelimiter")
    void create2(String text, String expectedDelimiter, String expectedStringNumbersWithDelimiter) {
        // given
        StringNumbersWithDelimiter stringNumbersWithDelimiter = StringNumbersWithDelimiter.of(text);

        // expect
        assertThat(ReflectionTestUtils.getField(stringNumbersWithDelimiter, "delimiter"))
                .isEqualTo(expectedDelimiter);
        assertThat(ReflectionTestUtils.getField(stringNumbersWithDelimiter, "stringNumbersWithDelimiter"))
                .isEqualTo(expectedStringNumbersWithDelimiter);
    }

    private static Stream<Arguments> expressionProviderWithCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", ";", "1;2;3"),
                Arguments.of("//@\n5@2@3", "@", "5@2@3"),
                Arguments.of("//%\n4%2%3", "%", "4%2%3"),
                Arguments.of("//#\n2#2#3", "#", "2#2#3"),
                Arguments.of("//!\n1!2!3", "!", "1!2!3")
        );
    }

    @DisplayName("toStringNumbers 메소드를 호출하는 순간, 구분자를 가지는 숫자 문자열을 String 배열로 반환한다")
    @ParameterizedTest
    @MethodSource("expressionProviderWithDelimiter")
    void toStringNumbers(StringNumbersWithDelimiter stringNumbersWithDelimiter, String[] expectedResult) {
        // expect
        assertThat(stringNumbersWithDelimiter.toStringNumbers()).containsExactlyInAnyOrder(expectedResult);
    }

    private static Stream<Arguments> expressionProviderWithDelimiter() {
        return Stream.of(
                Arguments.of(StringNumbersWithDelimiter.of("1,2,3"), new String[]{"1", "2", "3"}),
                Arguments.of(StringNumbersWithDelimiter.of("3:5:1"), new String[]{"3", "5", "1"}),
                Arguments.of(StringNumbersWithDelimiter.of("7,1:9"), new String[]{"7", "1", "9"}),
                Arguments.of(StringNumbersWithDelimiter.of("//%\n4%2%3"), new String[]{"4", "2", "3"}),
                Arguments.of(StringNumbersWithDelimiter.of("//#\n2#2#3"), new String[]{"2", "2", "3"}),
                Arguments.of(StringNumbersWithDelimiter.of("//!\n1!2!3"), new String[]{"1", "2", "3"})
        );
    }
}
