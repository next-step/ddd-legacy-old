package camp.nextstep.edu.calculator;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class CalculateInfo {

    private final static String MULTI_SPLIT_SEPARATOR = "|";

    private List<String> separatorList;
    private String targetText;

    private CalculateInfo() {

    }

    private CalculateInfo(List<String> separatorList, String targetText) {
        this.separatorList = separatorList;
        this.targetText = targetText;
    }

    public List<String> getSeparatorList() {
        return separatorList;
    }

    private void setSeparatorList(List<String> separatorList) {
        this.separatorList = separatorList;
    }

    public String getTargetText() {
        return targetText;
    }

    private void setTargetText(String targetText) {
        this.targetText = targetText;
    }

    public List<Integer> getSplitIntegerList() {
        String separator = String.join(MULTI_SPLIT_SEPARATOR, this.separatorList);
        String[] splitArray = this.targetText.split(separator);

        return Arrays.stream(splitArray).mapToInt(Integer::valueOf).boxed().collect(toList());
    }

    public boolean isEmpty() {

        if (CollectionUtils.isEmpty(this.separatorList)) {
            return true;
        }

        if (Objects.isNull(this.targetText)) {
            return true;
        }

        return false;
    }

    public static CalculateInfo getInstance() {
        return new CalculateInfo();
    }

    public static CalculateInfo getInstance(List<String> separatorList, String targetText) {
        return new CalculateInfo(separatorList, targetText);
    }
}
