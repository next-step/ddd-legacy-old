package camp.nextstep.edu.calculator;

class Delimiter {

    private String text;

    private String delimiter;

    Delimiter(String text, String delimiter) {
        this.text = text;
        this.delimiter = delimiter;
    }

    String[] getNumbers() {
        return this.text.split(this.delimiter);
    }
}