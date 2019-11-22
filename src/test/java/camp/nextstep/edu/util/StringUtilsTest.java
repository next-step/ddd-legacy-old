package camp.nextstep.edu.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("isBlank - 문자열이 공백 또는 null 이면 true")
    @ParameterizedTest(name = "{displayName} [{index}] - value : [{0}]")
    @NullAndEmptyAndWhiteSpaceStringSource
    void isBlankTrue(String value) throws Exception {
        assertThat(StringUtils.isBlank(value)).isTrue();
    }

    @DisplayName("isBlank - 공백 또는 null 이 아닌 값이면 false")
    @Test
    void isBlankFalse() throws Exception {
        String value = "1";

        assertThat(StringUtils.isBlank(value)).isFalse();
    }

}
