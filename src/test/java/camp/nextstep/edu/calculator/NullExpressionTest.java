package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("빈 계산식 테스트")
class NullExpressionTest {

    @DisplayName("NullExpression 의 모든 값을 더하면 Value 의 기본 값을 반환한다.")
    @Test
    void sumAll() {
        // when
        final Positive positive = NullExpression.INSTANCE.sumAll();
        final Positive expected = Positive.DEFAULT;

        // then
        assertThat(positive).isEqualTo(expected);
    }
}