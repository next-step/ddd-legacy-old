package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.DisabledIf;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Number 객체를 담는 클래스 테스트 코드 작성")
class NumbersTest {

    private Numbers numbers;

    @DisplayName("String 배열을 파라미터로 던지면 Numbers 객체의 인스턴스를 생성할 수 있다.")
    @Test
    void intValuesOf() {
        // when
        numbers = numbers.intValuesOf(new String[]{"1", "2"});

        // then
        assertThat(numbers).isNotNull();
    }
}