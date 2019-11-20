package camp.nextstep.edu.calculator;

public class StringCalculator {
    private static final String SPLITTER = "\\,|\\:";

    private int sum;
    private Tokens tokens;

    public StringCalculator() {
        sum = 0;
        tokens = new Tokens();
    }

    public int add(String text) {
        if (isZero(text)) {
            return 0;
        }
        return sum += getSum(split(text));
    }

    private String[] split(String text) {
        return text.split(SPLITTER);
    }

    private int getSum(String[] texts) {
        for (String text : texts) {
            sum += Integer.parseInt(text);
        }
        return sum;
    }

    private boolean isZero(String text) {
        if (checkNull(text) || checkNullString(text)) {
            return true;
        }
        return false;
    }

    private boolean checkNull(String text) {
        if (text == null) {
            return true;
        }
        return false;
    }

    private boolean checkNullString(String text) {
        if (text.isEmpty()) {
            return true;
        }
        return false;
    }

}
