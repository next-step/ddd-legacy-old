package camp.nextstep.edu.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}