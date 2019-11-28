package camp.nextstep.edu.calculator;

public class AdditionCalculator {
    private final Extractor extractor;

    AdditionCalculator(final Extractor extractor) {
        this.extractor = extractor;
    }

    public int execute(final String input) {
        return this.extractor.get(input).sum();
    }
}
