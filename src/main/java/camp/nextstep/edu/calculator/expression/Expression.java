package camp.nextstep.edu.calculator.expression;

import camp.nextstep.edu.calculator.value.Number;

public interface Expression {

    Number sumAll();

    boolean contains(Expression expression);
}
