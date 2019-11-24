package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CalculatorNumbers {

    private List<Number> numberList = new ArrayList<>();

    void add(String[] numbers) {
        List<Number> newNumbers = Stream.of(numbers)
            .map(Integer::new)
            .map(Number::new)
            .collect(Collectors.toList());

        numberList.addAll(newNumbers);
    }

    int totalSum() {
        return numberList.stream()
            .map(number -> number.getNumber())
            .reduce(0, Integer::sum);
    }

}
