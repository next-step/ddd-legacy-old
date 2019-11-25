package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력 값 방어 테스트")
class GuardTest {

    @DisplayName("빈 문자열 또는 null 을 입력할 경우 true 를 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void isNullOrBlank(final String value) {
        // when
        final boolean result = Guard.isNullOrBlank(value);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("빈 문자열 또는 null 이 아닌 경우 false 를 반환한다.")
    @ValueSource(strings = {"a", "asf", "hello"})
    @ParameterizedTest
    void isNullOrBlank_false(final String value) {
        // when
        final boolean result = Guard.isNullOrBlank(value);

        // then
        assertThat(result).isFalse();
    }
}