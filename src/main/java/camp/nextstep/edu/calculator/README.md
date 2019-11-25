# 1단계 - 문자열 덧셈 계산기

## 실습 환경 구축
* 키친포스 GitHub 저장소를 기반으로 미션을 진행한다.
* 미션 시작 버튼을 눌러 미션을 시작한다.
* 저장소에 자신의 GitHub 아이디로 된 브랜치가 생성되었는지 확인한다.
* 저장소를 자신의 계정으로 Fork 한다.
* 요구 사항에 대한 구현을 완료한 후, 작업이 다 되었으면 Push를 한다.
* `next-step/ddd-kitchenpos`에서 Pull Request를 작성한다.
* 리뷰 받은 내용을 토대로 코드를 리팩터링하고 다시 Push를 한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 문자열 덧셈 계산기
### 요구 사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 힌트

1. 빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다. (예 : “” => 0, null => 0)
```java
if (text == null) {}
if (text.isEmpty()) {}
```

2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
```java
int number = Integer.parseInt(text);
```

3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. (예 : “1,2”)
```java
String[] numbers = text.split(",");
``` 

4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
```java
String[] tokens= text.split(",|:");
``` 

5. "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
```java
Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
if (m.find()) {
    String customDelimiter = m.group(1);
    String[] tokens= m.group(2).split(customDelimiter);
}
``` 

6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
#### 테스트 코드
```java
class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String text) {
        assertThat(calculator.add(text)).isZero();
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void oneNumber(final String text) {
        assertThat(calculator.add(text)).isSameAs(Integer.parseInt(text));
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void twoNumbers(final String text) {
        assertThat(calculator.add(text)).isSameAs(3);
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    void colons(final String text) {
        assertThat(calculator.add(text)).isSameAs(6);
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    void customDelimiter(final String text) {
        assertThat(calculator.add(text)).isSameAs(6);
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    void negative() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.add("-1"));
    }
}
``` 
