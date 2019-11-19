package camp.nextstep.edu.racingcar;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int BOUND = 9;
    private static final int MOVING_CONDITION = 4;

    private final Random random = ThreadLocalRandom.current();

    @Override
    public boolean movable() {
        return random.nextInt(BOUND) >= MOVING_CONDITION;
    }
}
