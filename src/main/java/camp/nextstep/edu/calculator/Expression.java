package camp.nextstep.edu.calculator;

public interface Expression<T> {

    CalculateValue sumAll();
    boolean contains(T rawValue);
}
