package camp.nextstep.edu.calculator;

import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern ONLY_USED_NUMERIC = Pattern.compile("^(?-)[0-9]+$");

    public int add(String expression) {

        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        if (ONLY_USED_NUMERIC.matcher(expression).matches()) {
            return getNumberValue(expression);
        }

        ExpressionParser parser = new ExpressionParser(expression);
        return sum(parser.getValue());
    }

    private int sum(List<String> valueList) {
        int sum = 0;
        for (String value : valueList) {
            sum += getNumberValue(value);
        }
        return sum;
    }

    private int getNumberValue(String value) {
        NumberValue numberValue = new NumberValue(value);
        if (numberValue.isNegative()) {
            throw new NegativeNumberException();
        }
        return numberValue.getNumber();
    }

}
