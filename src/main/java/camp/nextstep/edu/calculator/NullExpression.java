package camp.nextstep.edu.calculator;

enum NullExpression implements Expression {

    INSTANCE;

    @Override
    public Positive sumAll() {
        return Positive.DEFAULT;
    }
}
