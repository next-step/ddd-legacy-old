package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionsTest {

    @Test
    void checkValidExpressions() {
        Expressions expressions = Expressions.of("1,2,3,4:5");
        assertThat(expressions.getValidExpressions()).containsExactly("1", "2", "3", "4", "5");
    }

}
