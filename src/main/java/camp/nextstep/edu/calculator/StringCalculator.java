package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern CUSTOM_TOKEN = Pattern.compile("//(.)\n(.*)");

    public int add(String text) {
        if (!isEmpty(text)) {
            return sum(text);
        }
        return 0;
    }

    private int sum(String text) {
        ;
    }

    private String[] splitNumberByToken(String text) {
        Matcher m = CUSTOM_TOKEN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
        }
        return text.split("[,:]");
    }

    private void checkNegativeNumber(int number){
        if(number < 0){
            throw new RuntimeException();
        }
    }

    private boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}


