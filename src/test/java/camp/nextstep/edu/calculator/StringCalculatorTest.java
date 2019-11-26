package camp.nextstep.edu.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@BeforeEach
	void setUp() {
		stringCalculator = new StringCalculator();
	}

	@DisplayName("문자열 덧셈 계산기 - 구분자 , 또는 : 경우")
	@ParameterizedTest
	@CsvSource(value = {"=0", "1,2=3", "1,2,3=6", "1,2:3=6"}, delimiter = '=')
	void 문자열_덧셈_계산기(final String text, final int sum) {
		assertThat(stringCalculator.add(text)).isEqualTo(sum);
	}

	@DisplayName("커스텀 구분자 문자열 덧셈 계산기 - 실제로 구분자를 //와 \n의 사이에 커스텀 구분자를 지정")
	@ParameterizedTest
	@MethodSource
	void 커스텀_구분자_문자열_덧셈_계산기(final String text, final int sum) {
		assertThat(stringCalculator.add(text)).isEqualTo(sum);
	}

	private static Stream<Arguments> 커스텀_구분자_문자열_덧셈_계산기() {
		return Stream.of(Arguments.of("//;\n1;2;3", 6));
	}

	@DisplayName("커스텀 구분자 문자열 덧셈 계산기 - 숫자 이외의 값 이나 음수일 때 RuntimeException 발생")
	@ParameterizedTest
	@ValueSource(strings = {"a:1,2", "a,b:-c", "-1,2,3", "1:-2,3", "1:2:-3", "//;\n-1;2;3"})
	void 기본_문자열_음수(final String text) {
		assertThatThrownBy(() -> stringCalculator.add(text)).isInstanceOf(RuntimeException.class);
	}

}