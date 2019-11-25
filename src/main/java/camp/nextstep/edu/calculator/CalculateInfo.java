package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateInfo {

    private List<String> separatorList;
    private String targetText;

    public List<String> getSeparatorList() {
        return separatorList;
    }

    public void setSeparatorList(List<String> separatorList) {
        this.separatorList = separatorList;
    }

    public String getTargetText() {
        return targetText;
    }

    public void setTargetText(String targetText) {
        this.targetText = targetText;
    }

    public List<Integer> getSplitIntegerList() {
        String separator = String.join("|", this.separatorList);
        String[] splitArray = this.targetText.split(separator);

        return Arrays.stream(splitArray).map(Integer::valueOf).collect(Collectors.toList());
    }

    public static CalculateInfo getInstance(List<String> separatorList, String targetText) {

        CalculateInfo calculateInfo = new CalculateInfo();

        calculateInfo.setSeparatorList(separatorList);
        calculateInfo.setTargetText(targetText);

        return calculateInfo;
    }
}
