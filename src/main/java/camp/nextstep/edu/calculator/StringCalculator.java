package camp.nextstep.edu.calculator;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringCalculator {

    private List<Separator> separatorList = Arrays.asList(new CustomSeparator(), new DefaultSeparator());

    public int add(String input) {

        if (StringUtils.isEmpty(input)) {
            return 0;
        }

        for (Separator separator : separatorList) {

            CalculateInfo calculateInfo = separator.getCalculateInfo(input);
            List<Integer> splitResult = getSplitIntegerList(calculateInfo);

            if (CollectionUtils.isEmpty(splitResult)) {
                continue;
            }

            doValidateSplitResult(splitResult);
            return sum(splitResult);
        }

        throw new RuntimeException();
    }

    private List<Integer> getSplitIntegerList(CalculateInfo calculateInfo) {
        if (Objects.isNull(calculateInfo)) {
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
