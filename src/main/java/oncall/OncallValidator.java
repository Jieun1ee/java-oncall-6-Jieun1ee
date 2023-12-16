package oncall;

import java.util.ArrayList;
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

    public static Integer checkMonth(int num) {
        if (num < 1 || num > 12) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return num;
    }

    public static String checkStartDay(String input) {
        List<String> day = new ArrayList<>();
        day.add("일");
        day.add("월");
        day.add("화");
        day.add("수");
        day.add("목");
        day.add("금");
        day.add("토");

        if (!day.contains(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return input;
    }
}
