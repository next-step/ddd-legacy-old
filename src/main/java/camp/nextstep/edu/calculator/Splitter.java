package camp.nextstep.edu.calculator;

public interface Splitter {

    boolean supports(String stringValue);

    String[] split(String stringValue);

}
