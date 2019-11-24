package camp.nextstep.edu.calculator;

enum NullExpression implements Expression<Object> {

    INSTANCE;

    @Override
    public CalculateValue sumAll() {
        return CalculateValue.DEFAULT;
    }

    @Override
    public boolean contains(Object ignored) {
        return false;
    }
}
