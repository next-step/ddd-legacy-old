package camp.nextstep.edu.calculator.expression;

import camp.nextstep.edu.calculator.value.Number;
import camp.nextstep.edu.calculator.value.Zero;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("빈 계산식 테스트")
class NullExpressionTest {

    @DisplayName("NullExpression 의 모든 값을 더하면 Value 의 기본 값을 반환한다.")
    @Test
    void sumAll() {
        // when
        final Number positive = NullExpression.INSTANCE.sumAll();
        final Number expected = Zero.INSTANCE;

        // then
        assertThat(positive).isEqualTo(expected);
    }
}