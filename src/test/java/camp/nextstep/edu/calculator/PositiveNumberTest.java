package camp.nextstep.edu.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

    @DisplayName("0 이상의 숫자 문자열을 받아 PositiveNumber 생성")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10000000"})
    void parse_given_strings(String testInput) {
        PositiveNumber result = PositiveNumber.of(testInput);
        assertThat(result.value()).isEqualTo(Long.parseLong(testInput));
    }

    @DisplayName("음수 문자열로 PositiveNumber 생성 볼가능")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-10000000"})
    void parse_given_negative_number_strings(String testInput) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            PositiveNumber.of(testInput)
        );
    }

    @DisplayName("숫자로된 문자열 리스트를 받아서 PositiveNumber 리스트를 반환한다")
    @Test
    void parseStrings() {
        //given
        List<String> testInputList = Arrays.asList(
            "0",
            "1",
            "100");

        //when
        List<PositiveNumber> result = PositiveNumber.of(testInputList);

        //then
        List<Long> resultValues = result.stream().map(PositiveNumber::value)
            .collect(Collectors.toList());
        assertThat(resultValues).containsSequence(
            0L,
            1L,
            100L);
    }

    @DisplayName("같은 숫자에 대해서 isSame은 true를 반환한다")
    @Test
    void given_same_number_isSame_return_true() {
        PositiveNumber numberFromInt = PositiveNumber.of("5");
        PositiveNumber numberFromString = PositiveNumber.of("5");

        assertThat(numberFromInt.isSame(numberFromString)).isTrue();
    }

    @DisplayName("같은 숫자에 대해서 isSame은 true를 반환한다")
    @Test
    void given_different_number_isSame_return_false() {
        PositiveNumber numberFromInt = PositiveNumber.of("10");
        PositiveNumber numberFromString = PositiveNumber.of("5");

        assertThat(numberFromInt.isSame(numberFromString)).isFalse();
    }

    @DisplayName("add시 값이 더해진 value를 갖는 새로운 PositiveNumber를 반환한다")
    @ParameterizedTest
    @MethodSource("addValueProvider")
    void add_returns_new_PositiveNumber_with_added_value(String target, String added,long expected){
        PositiveNumber result =
            PositiveNumber.of(target)
            .add(PositiveNumber.of(added));

        assertThat(result.value()).isEqualTo(expected);

    }
    @DisplayName("null을 add 할 수 없다")
    @Test
    void given_null_add_throws_exception() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            PositiveNumber.of("10").add(null)
        );
    }

    static Stream<Arguments> addValueProvider(){
        return Stream.of(
            arguments("1", "2", 3),
            arguments("100","320",420),
            arguments(String.valueOf(Integer.MAX_VALUE), String.valueOf(Integer.MAX_VALUE),(long)(Integer.MAX_VALUE) *2)
        );
    }
}