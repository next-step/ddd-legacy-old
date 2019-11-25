package camp.nextstep.edu.calculator;

import java.util.List;

class Numbers {
    private List<Number> numbers;

    public Numbers(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public int toSumInt() {
        return numbers.stream()
                .mapToInt(Number::getNumber)
                .sum()
                ;
    }

}
