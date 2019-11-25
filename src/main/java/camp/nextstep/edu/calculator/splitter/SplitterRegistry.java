package camp.nextstep.edu.calculator.splitter;

import java.util.Arrays;
import java.util.List;

public class SplitterRegistry {

    static final Splitter DEFAULT_SPLITTER = new DefaultSplitter();

    private final List<Splitter> splitters;

    public SplitterRegistry(Splitter... splitters) {
        this.splitters = Arrays.asList(splitters);
    }

    public Splitter getSplitter(String value) {
        return splitters.stream()
                .filter(splitter -> splitter.supports(value))
                .findFirst()
                .orElse(DEFAULT_SPLITTER);
    }

}
