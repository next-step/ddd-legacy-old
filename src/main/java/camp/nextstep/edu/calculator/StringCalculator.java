package camp.nextstep.edu.calculator;

final class StringCalculator implements Calculator<String> {

    @Override
    public int calculate(final String rawExpression) {
        final Expression expression = StringExpression.of(rawExpression);
        final CalculateValue result = expression.sumAll();

        return result.toInt();
    }
}
