package camp.nextstep.edu.calculator;

class StringValidator {

    static void checkFormat(String text) {
        if (text == null || text.isEmpty()){
            throw new IllegalArgumentException();
        }
    }
}
