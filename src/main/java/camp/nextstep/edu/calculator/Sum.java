package camp.nextstep.edu.calculator;

public class Sum {
    private int sum;

    public Sum(int sum) {
        this.sum = sum;
    }

    public int print() {
        return sum;
    }

    public void add(int value) {
        sum += value;
    }
}
