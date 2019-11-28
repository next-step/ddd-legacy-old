package camp.nextstep.edu.calculator;

@FunctionalInterface
public interface Extractor {
    Numbers get(String value);
}
