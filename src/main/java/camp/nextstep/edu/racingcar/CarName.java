package camp.nextstep.edu.racingcar;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public class CarName {

    public static final int MAX_LENGTH = 5;

    private static final Map<String, CarName> CACHE = new WeakHashMap<>();

    private final String carName;

    private CarName(final String carName) {
        validate(carName);

        this.carName = carName;
    }

    public static CarName of(final String carName) {
        return CACHE.computeIfAbsent(carName, CarName::new);
    }

    private void validate(final String carName) {
        if (carName == null || carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final CarName that = (CarName) o;
        return Objects.equals(carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
