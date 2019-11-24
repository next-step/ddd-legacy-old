package camp.nextstep.edu.calculator.splitter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterRegistryTest {

    @DisplayName("getSplitter - 지원되는 splitter 가 있으면 지원되는 splitter 가 반환된다.")
    @Test
    void getSplitter() throws Exception {
        Splitter splitter = new TestSplitter(true);

        SplitterRegistry splitterRegistry = new SplitterRegistry(splitter);

        final Splitter result = splitterRegistry.getSplitter(null);

        assertThat(result).isSameAs(splitter);
    }

    @DisplayName("getSplitter - 지원되는 splitter 가 없으면 DEFAULT_SPLITTER 가 반환된다.")
    @Test
    void getSplitterNotExist() throws Exception {
        Splitter splitter = new TestSplitter(false);

        SplitterRegistry splitterRegistry = new SplitterRegistry(splitter);

        final Splitter result = splitterRegistry.getSplitter(null);

        assertThat(result).isSameAs(SplitterRegistry.DEFAULT_SPLITTER);
    }

    private static class TestSplitter implements Splitter {

        private final boolean supports;

        private TestSplitter(boolean supports) {
            this.supports = supports;
        }

        @Override
        public boolean supports(String value) {
            return this.supports;
        }

        @Override
        public String[] split(String value) {
            return new String[0];
        }
    }
}
