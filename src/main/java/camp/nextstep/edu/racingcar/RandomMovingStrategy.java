package camp.nextstep.edu.racingcar;

import java.util.Random;

class RandomMovingStrategy implements MovingStrategy {

    static final int MOVABLE_CONDITION = 4;
    private static final int NUMBER_OF_MAX = 9;

    @Override
    public boolean movable() {
        return new Random().nextInt(NUMBER_OF_MAX) >= MOVABLE_CONDITION;
    }
}
