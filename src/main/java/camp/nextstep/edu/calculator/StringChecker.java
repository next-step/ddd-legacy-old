package camp.nextstep.edu.calculator;

import java.util.Objects;

class StringChecker {

    static boolean isEmpty(final String text){
        return Objects.isNull(text) || text.isEmpty();
    }

}
