package camp.nextstep.edu.calculator.util;

import camp.nextstep.edu.calculator.exception.NegativeNumberException;

public final class Number {

    private static final int ZERO_VALUE = 0;

    /**
     * Parse string number into integer number
     *
     * @param number
     * @return parsed integer value
     */
    public static int parseInt(final String number) {
        int parsedNumber = Integer.parseInt(number);

        if (isNegativeNumber(parsedNumber)) {
            throw new NegativeNumberException(parsedNumber);
        }

        return parsedNumber;
    }

    /**
     * Check whether positive number or not
     *
     * @param number
     * @return boolean value whether positive number or not
     */
    private static boolean isNegativeNumber(final int number) {
        return number < ZERO_VALUE;
    }
}
