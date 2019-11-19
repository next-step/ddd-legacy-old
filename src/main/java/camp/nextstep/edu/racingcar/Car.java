package camp.nextstep.edu.racingcar;

public class Car {

    private final CarName name;
    private int position;

    Car(final String name) {
        this(name, 0);
    }

    Car(final String name, final int position) {
        this.name = CarName.of(name);
        this.position = position;
    }

    void move(final RandomMovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position++;
        }
    }

    boolean isInPosition(final int position) {
        return this.position == position;
    }


}
