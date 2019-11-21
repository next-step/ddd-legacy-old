package camp.nextstep.edu.calculator;

import java.util.Objects;

public class Calculator {

    public int add(String input) {
        if (isEmptyString(input)) {
            return 0;
        }

        String[] numbers = input.split("\\,|\\:");

        return getSum(numbers);
    }

    private int getSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private boolean isEmptyString(String str) {
        return Objects.isNull(str) || str.isEmpty();
    }
}
