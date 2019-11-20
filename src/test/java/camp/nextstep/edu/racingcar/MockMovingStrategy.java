package camp.nextstep.edu.racingcar;

public class MockMovingStrategy implements MovingStrategy {
    private boolean result;

    public MockMovingStrategy(boolean result) {
        this.result = result;
    }

    @Override
    public boolean movable() {
        return result;
    }
}
