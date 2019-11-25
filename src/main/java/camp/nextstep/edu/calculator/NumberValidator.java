package camp.nextstep.edu.calculator;

class NumberValidator {
    int validatePositive(String text) {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new RuntimeException("Negative Number");
        }

        return number;
    }
}
