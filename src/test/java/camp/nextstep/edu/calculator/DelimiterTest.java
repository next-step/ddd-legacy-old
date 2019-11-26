package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterTest {

    @Test
    @DisplayName(value = "구분자를 이용한 변환 확인")
    void delimiterConstructor() {

        String inputData = "1,2,3,4,5";
        Delimiter delimiter = new Delimiter(inputData, ",");

        String[] numbers = delimiter.getNumbers();

        assertThat(numbers).isSubsetOf("1", "2", "3", "4", "5");
    }
}