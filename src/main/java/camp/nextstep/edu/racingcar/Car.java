package camp.nextstep.edu.racingcar;

import org.springframework.util.StringUtils;

public class Car {
    private final String name;
    private int position;

    Car(final String name) {
        this(name, 0);
    }

    Car(final String name, final int position) {
        validate(name);
        this.name = name;
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

    private void validate(final String name) {
        if (StringUtils.isEmpty(name) || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public boolean matchByName(String name) {
        return this.name.equals(name);
    }
}
