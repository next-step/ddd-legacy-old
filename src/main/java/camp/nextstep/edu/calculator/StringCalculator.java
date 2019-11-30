package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String input) {

        if (StringUtils.isEmpty(input)) {
            return 0;
        }

        Separator separator = SeparatorSelector.getSeparator(input);

        CalculateInfo calculateInfo = separator.getCalculateInfo(input);
        List<Integer> splitResult = getSplitIntegerList(calculateInfo);

        doValidateSplitResult(splitResult);
        return sum(splitResult);

    }

    private List<Integer> getSplitIntegerList(CalculateInfo calculateInfo) {
        if (calculateInfo.isEmpty()) {
            return new ArrayList<>();
        }

        return calculateInfo.getSplitIntegerList();
    }

    private void doValidateSplitResult(List<Integer> splitResult) {
        for (Integer value : splitResult) {
            if (value < 0) {
                throw new RuntimeException();
            }
        }
    }

    private int sum(List<Integer> integerList) {
        return integerList.stream().reduce(0, Integer::sum);
    }
}
