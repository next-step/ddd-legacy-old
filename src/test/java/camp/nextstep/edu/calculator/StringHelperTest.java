package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringHelperTest {

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 true 를 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmpty(final String text) {
        assertThat(StringHelper.isNullOrEmpty(text)).isTrue();
    }
}