package camp.nextstep.edu.calculator.util;

import camp.nextstep.edu.calculator.exception.NegativeNumberException;

public final class Integer extends Number implements Comparable<Integer> {
    
    private static final int ZERO_VALUE = 0;
    private final int value;
    
    public Integer(int value) {
        this.value = value;
    }
    
    /**
     * Parse string number into integer number
     *
     * @param number
     * @return parsed integer value
     */
    public static int parsePositiveInt(final String number) {
        int parsedNumber = java.lang.Integer.parseInt(number);
        
        if (isNegativeNumber(parsedNumber)) {
            throw new NegativeNumberException(parsedNumber);
        }
        
        return parsedNumber;
    }
    
    /**
     * Check whether positive number or not
     *
     * @param value
     * @return boolean value whether positive number or not
     */
    private static boolean isNegativeNumber(final int value) {
        return value < ZERO_VALUE;
    }
    
    /**
     * Returns the value of this {@code Integer} as an {@code int}.
     *
     * @return primitive int value
     */
    public int intValue() {
        return value;
    }
    
    /**
     * Returns the value of this {@code Integer} as a {@code long} after a widening primitive
     * conversion.
     *
     * @return primitive long value
     */
    public long longValue() {
        return (long) value;
    }
    
    /**
     * Returns the value of this {@code Integer} as a {@code float} after a widening primitive
     * conversion.
     *
     * @return primitive float value
     */
    public float floatValue() {
        return (float) value;
    }
    
    /**
     * Returns the value of this {@code Integer} as a {@code double} after a widening primitive
     * conversion.
     *
     * @return primitive double value
     */
    public double doubleValue() {
        return (double) value;
    }
    
    /**
     * Compares two {@code Integer} objects numerically.
     *
     * @param   anotherInteger   the {@code Integer} to be compared.
     * @return  the value {@code 0} if this {@code Integer} is
     *          equal to the argument {@code Integer}; a value less than
     *          {@code 0} if this {@code Integer} is numerically less
     *          than the argument {@code Integer}; and a value greater
     *          than {@code 0} if this {@code Integer} is numerically
     *           greater than the argument {@code Integer} (signed
     *           comparison).
     */
    public int compareTo(final Integer anotherInteger) {
        return compare(this.value, anotherInteger.value);
    }
    
    /**
     * Compares two {@code int} values numerically.
     * The value returned is identical to what would be returned by:
     * <pre>
     *    Integer.valueOf(x).compareTo(Integer.valueOf(y))
     * </pre>
     *
     * @param  x the first {@code int} to compare
     * @param  y the second {@code int} to compare
     * @return the value {@code 0} if {@code x == y};
     *         a value less than {@code 0} if {@code x < y}; and
     *         a value greater than {@code 0} if {@code x > y}
     */
    public static int compare(final int x, final int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}
