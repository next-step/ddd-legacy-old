package camp.nextstep.edu.calculator;

@FunctionalInterface
interface Calculator<T> {

    int calculate(T rawValue);
}
