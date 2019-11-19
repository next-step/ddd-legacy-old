package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NullExpressionTest {

    @DisplayName("NullExpression 의 모든 값을 더하면 Value 의 기본 값을 반환한다.")
    @Test
    void sumAll() {
        // given
        final Expression nullExpression = new NullExpression();

        // when
        final Value value = nullExpression.sumAll();
        final Value expected = Value.DEFAULT;

        // then
        assertThat(value).isEqualTo(expected);
    }
}