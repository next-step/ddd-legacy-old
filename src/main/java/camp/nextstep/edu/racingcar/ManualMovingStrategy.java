package camp.nextstep.edu.racingcar;

public class ManualMovingStrategy implements MovingStrategy {

    private final int move;

    public ManualMovingStrategy(int move) {
        this.move = move;
    }

    @Override
    public boolean movable() {
        return move >= Car.MOVE_CONDITION;
    }
}
