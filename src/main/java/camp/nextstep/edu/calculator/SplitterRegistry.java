package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;

public class SplitterRegistry {

    static final Splitter DEFAULT_SPLITTER = new DefaultSplitter();

    private final List<Splitter> splitters;

    public SplitterRegistry(Splitter... splitters) {
        this.splitters = Arrays.asList(splitters);
    }

    public Splitter getSplitter(String stringValue) {
        return splitters.stream()
                .filter(splitter -> splitter.supports(stringValue))
                .findFirst()
                .orElse(DEFAULT_SPLITTER);
    }
}
