package camp.nextstep.edu.racingcar;

public class FixedNumberGenerator implements NumberGenerator {
    private int fixedNumber;

    public FixedNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generateNumber() {
        return fixedNumber;
    }
}