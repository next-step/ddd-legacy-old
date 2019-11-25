package camp.nextstep.edu.calculator;

import java.util.Arrays;
import org.springframework.util.StringUtils;

public class StringCalculator {

	private static final String DELIMITER = ",|:";

	/**
	 * Add string of integer numbers which is included with comma(,) or colon(:)
	 *
	 * @param numbers
	 * @return sum of integer numbers
	 */
	public int add(final String numbers) {
		if (StringUtils.isEmpty(numbers)) {
			return 0;
		}

		return Arrays.stream(numbers.split(DELIMITER))
			.mapToInt(Integer::valueOf)
			.sum();
	}


}
