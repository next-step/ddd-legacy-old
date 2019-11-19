package camp.nextstep.edu.calculator;

class Guard {

    private Guard() {
    }

    static boolean isNullOrBlank(final String value) {
        return value == null || value.isBlank();
    }
}
