package camp.nextstep.edu.calculator;

class StringCalculator {

    public static int add(final String text) {
        Expressions expressions = Expressions.of(text);
        Numbers numbers = expressions.toNumbers();
        return numbers.toSumInt();
    }
}
