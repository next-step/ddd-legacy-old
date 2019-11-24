package camp.nextstep.edu.calculator;

public class Delimiter {

    private String text;

    private String delimiter;

    public Delimiter(String text, String delimiter) {
        this.text = text;
        this.delimiter = delimiter;
    }

    public String[] getNumbers() {
        return this.text.split(this.delimiter);
    }
}