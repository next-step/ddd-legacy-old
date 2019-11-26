package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringCheckerTest {

    @DisplayName("빈문자열 확인")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull_text(final String text) {
        assertThat(StringChecker.isEmpty(text)).isTrue();
    }

    @DisplayName("정상 문자열 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void success_text(final String text) {
        assertThat(StringChecker.isEmpty(text)).isFalse();
    }

}