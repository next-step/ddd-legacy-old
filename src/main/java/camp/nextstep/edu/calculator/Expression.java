package camp.nextstep.edu.calculator;

public class Expression {
    private static final String DEFAULT_SEPARATORS = "(,)|(:)";
    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_END = "\n";

    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    boolean isEmpty() {
        return this.isEmptyString(this.expression);
    }

    private boolean isEmptyString(final String expression) {
        return (expression == null) || ("".equals(expression));
    }
}
