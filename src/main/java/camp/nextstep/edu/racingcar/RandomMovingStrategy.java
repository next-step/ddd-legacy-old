package camp.nextstep.edu.racingcar;

public class RandomMovingStrategy {
    private NumberGenerator numberGenerator;

    public RandomMovingStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    boolean movable() {
        return numberGenerator.generateNumber() >= 4;
    }
}
