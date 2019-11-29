package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.context.junit.jupiter.DisabledIf;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Number 객체를 담는 클래스 테스트 코드 작성")
class NumbersTest {

    private Numbers numbers;

    @DisplayName("String 배열을 파라미터로 던지면 Numbers 객체의 인스턴스를 생성할 수 있다.")
    @Test
    void create() {
        // when
        numbers = numbers.intValuesOf(new String[]{"1", "2"});

        // then
        assertThat(numbers).isNotNull();
    }

    @DisplayName("정상적인 문자배열을 던지면 Numbers 객체 생성후 합을 구할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"'1,2'=3", "'1,2,3'=6"}, delimiter = '=')
    void sum(String input, int expected) {
        // given
        String[] splitedInput = input.split(",");

        // when
        numbers = numbers.intValuesOf(splitedInput);

        // then
        assertThat(numbers.sum().getValue()).isEqualTo(expected);
    }
}