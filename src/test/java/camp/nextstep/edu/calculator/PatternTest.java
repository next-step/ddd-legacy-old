package camp.nextstep.edu.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class PatternTest {
    @Test
    public void compile() {
        Pattern compile1 = Pattern.compile("a|b");
        assertThat(compile1.split("!a?")).contains("!");
    }
    @Test
    public void compile_escaped() {
        Pattern compile1 = Pattern.compile("|", Pattern.LITERAL);
        assertThat(compile1.split("a|b")).contains("a","b");
    }
    @Test
    public void quote(){
        String quoted = Pattern.quote("|");
        assertThat(quoted).isNotEqualTo("|");
        assertThat("a|b".split(quoted)).contains("a","b");
    }

}
