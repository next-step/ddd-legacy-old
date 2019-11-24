package camp.nextstep.edu.calculator;

interface Expression<T> {

    CalculateValue sumAll();

    boolean contains(T rawValue);
}
