package camp.nextstep.edu.racingcar;

public class Car {
    static final int START_POSITION = 0;
    static final int LENGTH_OF_NAME = 5;

    private final String name;
    private int position;

    Car(final String name) {
        this(name, START_POSITION);
    }

    private Car(final String name, final int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        if (LENGTH_OF_NAME <= name.length()) {
            throw new IllegalArgumentException(String.format("이름은 %d글자 미만이어야 합니다.", LENGTH_OF_NAME));
        }
        return new Car(name);
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
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
