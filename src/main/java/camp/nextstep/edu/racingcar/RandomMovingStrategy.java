package camp.nextstep.edu.racingcar;

public class RandomMovingStrategy implements MovingStrategy {
    private ValueGenerator valueGenerator;

    public RandomMovingStrategy() {
        this.valueGenerator = new RandomValueGenerator();
    }

    RandomMovingStrategy(ValueGenerator valueGenerator) {
        this.valueGenerator = valueGenerator;
    }

    public boolean movable() {
        return valueGenerator.generate() >= 4;
    }
}
