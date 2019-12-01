package camp.nextstep.edu.calculator;

class Number {
    private StringParser parser;

    Number() {
        this.parser = new StringParser();
    }

    int getPositiveNumber(String text) {
        int number = parser.toIntFrom(text);
        if (number < 0) {
            throw new RuntimeException("Negative Number");
        }

        return number;
    }
}
