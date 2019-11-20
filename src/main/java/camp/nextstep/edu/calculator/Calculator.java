package camp.nextstep.edu.calculator;

class Calculator {

    private Calculator() {
    }

    static int calculate(final String rawExpression) {
        final Expression expression = StringExpression.of(rawExpression);
        final Positive result = expression.sumAll();

        return result.toInt();
    }
}
