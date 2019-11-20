package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tokens {
    private List<String> tokens;

    public Tokens() {
        tokens = new ArrayList<>();
    }

    public Tokens(String[] array) {
        for (String s : array) {
            tokens.add(s);
        }
    }

    public void addToken(String token) {
        tokens.add(token);
    }

    public String getToken() {
        int index = tokens.size() - 1;
        String token = tokens.get(index);
        tokens.remove(index);
        return token;
    }

    public int calculate(String[] values) {
        Arrays.stream(values).map(Integer::parseInt).reduce(Integer::sum).get();
        return 0;
    }
}
