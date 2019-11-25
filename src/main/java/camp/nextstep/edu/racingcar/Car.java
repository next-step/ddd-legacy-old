package camp.nextstep.edu.racingcar;

import org.apache.logging.log4j.util.Strings;

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

    void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position++;
        }
    }

    boolean isInPosition(final int position) {
        return this.position == position;
    }

    private void validate(final String name) {
        if (Strings.isEmpty(name) || name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글짜를 초과할 수 없습니다.");
        }
    }
}
