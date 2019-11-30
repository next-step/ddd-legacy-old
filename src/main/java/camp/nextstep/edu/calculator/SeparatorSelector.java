package camp.nextstep.edu.calculator;

public class SeparatorSelector {

    public static Separator getSeparator(String input) {

        if (input.startsWith(CustomSeparator.CustomSeparatorType.PREFIX_MARK.getMark())) {
            return new CustomSeparator();
        }

        return new DefaultSeparator();
    }
}
