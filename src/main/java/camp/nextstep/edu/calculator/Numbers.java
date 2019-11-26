package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.List;

public final class Numbers {
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers intValuesOf(String[] separatedTex) {
        return new Numbers(new ArrayList<Number>());
    }
}
