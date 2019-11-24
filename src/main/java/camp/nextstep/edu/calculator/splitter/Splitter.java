package camp.nextstep.edu.calculator.splitter;

public interface Splitter {

    boolean supports(String stringValue);

    String[] split(String stringValue);

}
