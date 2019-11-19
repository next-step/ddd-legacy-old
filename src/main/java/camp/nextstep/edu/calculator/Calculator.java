package camp.nextstep.edu.calculator;

class Calculator {

    private Calculator() {
    }

    static int calculate(final String expression) {
        if (Guard.isNullOrBlank(expression)) {
            return Value.DEFAULT;
        }

        return Integer.parseInt(expression);
    }
}
