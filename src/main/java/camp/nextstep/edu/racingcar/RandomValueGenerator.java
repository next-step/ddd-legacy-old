package camp.nextstep.edu.racingcar;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {
    @Override
    public int generate() {
        return new Random().nextInt(9);
    }
}
