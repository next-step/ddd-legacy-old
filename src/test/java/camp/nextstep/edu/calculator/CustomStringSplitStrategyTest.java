package camp.nextstep.edu.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CustomStringSplitStrategyTest {

    @DisplayName("생성 성공")
    @ParameterizedTest
    @MethodSource("successfulSplitStringsProvider")
    void construct(String[] input) {
        CustomStringSplitStrategy strategy = new CustomStringSplitStrategy(input);
    }

    @DisplayName("구분자 없거나 빈 리스트일 때 생성 실패")
    @ParameterizedTest
    @NullAndEmptySource
    void construct_fail(String[] input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CustomStringSplitStrategy strategy = new CustomStringSplitStrategy(input);
        });
    }

    @DisplayName("커스텀 구분자로 문자 자르기 성공")
    @ParameterizedTest
    @MethodSource("successfulSplitStringsProvider")
    void applyMany(String[] splitStrings, String testInput, List<String> testOutput){
        CustomStringSplitStrategy strategy = new CustomStringSplitStrategy(splitStrings);
        List<String> result = strategy.apply(testInput);
        assertThat(result).containsSequence(testOutput);
    }

    static Stream<Arguments> successfulSplitStringsProvider() {
        return Stream.of(
            arguments(new String[]{";"}, "a;b", Arrays.asList("a","b")),
            arguments(new String[]{";", "!"}, "a;b!c", Arrays.asList("a","b","c")),
            arguments(new String[]{"|", "~"}, "ab|cd~ef",  Arrays.asList("ab","cd","ef"))
        );
    }


}