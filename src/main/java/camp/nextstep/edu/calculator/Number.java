package camp.nextstep.edu.calculator;

class Number {
    private Integer number;

    private Number(final String numberString) {
        parseInt(numberString);
        validate(number);
    }

    static Number of(final String text) {
        return new Number(text);
    }

    public Integer getNumber() {
        return number;
    }

    private void validate(final int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private void parseInt(final String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

}
