package oncall;

import java.util.Arrays;
import java.util.List;

public class OncallValidator {
    private static final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.";
    private static final String COMMA = ",";
    private static final String SPACE = " ";

    public static List<String> splitWithComma(String input) {
        validateComma(input);
        return Arrays.asList(input.split(COMMA));
    }

    private static void validateComma(String input) {
        if (input.startsWith(COMMA) || input.endsWith(COMMA)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        if (input.contains(COMMA + COMMA) || input.contains(COMMA + SPACE) || input.contains(SPACE + COMMA)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
