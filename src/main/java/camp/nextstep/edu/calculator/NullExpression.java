package camp.nextstep.edu.calculator;

enum NullExpression implements Expression {

    INSTANCE;

    @Override
    public Number sumAll() {
        return Zero.INSTANCE;
    }

    @Override
    public boolean contains(Expression ignored) {
        return false;
    }
}
