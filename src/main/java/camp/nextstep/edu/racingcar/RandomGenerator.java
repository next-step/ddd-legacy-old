package camp.nextstep.edu.racingcar;

import java.util.Random;

public class RandomGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        return new Random().nextInt(9);
    }
}