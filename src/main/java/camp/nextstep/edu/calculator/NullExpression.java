package camp.nextstep.edu.calculator;

enum NullExpression implements Expression {
    INSTANCE;

    @Override
    public Value sumAll() {
        return Value.DEFAULT;
    }
}
