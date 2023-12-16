package oncall;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OncallValidator {
    private static final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.";
    private static final String COMMA = ",";
    private static final String SPACE = " ";

    public static void validateComma(String input) {
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

    public static Integer checkInteger(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void checkDuplicate(List<String> names) {
        List<String> duplicates = names.stream()
                .collect(Collectors.groupingBy(s -> s))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        if (!duplicates.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void checkWorker(List<String> weekdayWorker, List<String> holidayWorker) {
        checkPeopleNumber(weekdayWorker, holidayWorker);
        checkName(weekdayWorker);
        checkName(holidayWorker);
        checkWorkers(weekdayWorker, holidayWorker);
    }

    private static void checkPeopleNumber(List<String> weekdayWorker, List<String> holidayWorker) {
        if (weekdayWorker.size() != holidayWorker.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        if (weekdayWorker.size() < 5 || weekdayWorker.size() > 35) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void checkWorkers(List<String> weekdayWorker, List<String> holidayWorker) {
        for (String name : weekdayWorker) {
            if (!holidayWorker.contains(name)) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
    }

    private static void checkName(List<String> names) {
        for (String name : names) {
            if (name.length() > 5 || name.length() == 0) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
        if (names.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
