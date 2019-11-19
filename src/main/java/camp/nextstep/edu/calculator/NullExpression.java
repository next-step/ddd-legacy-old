package camp.nextstep.edu.calculator;

class NullExpression implements Expression {

    @Override
    public Value sumAll() {
        return Value.DEFAULT;
    }
}
