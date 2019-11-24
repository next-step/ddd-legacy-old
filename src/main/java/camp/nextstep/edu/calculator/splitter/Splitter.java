package camp.nextstep.edu.calculator.splitter;

public interface Splitter {

    boolean supports(String value);

    String[] split(String value);

}
