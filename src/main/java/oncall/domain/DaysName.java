package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class DaysName {
    private final String[] WEEKDAYS = {"일", "월", "화", "수", "목", "금", "토"};
    private final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.";

    private List<String> daysName;

    public DaysName(int days, String startDay) {
        this.daysName = setDaysName(days, startDay);
    }

    private int getStartDayIndex(String startDay) {
        for (int i = 0; i < WEEKDAYS.length; i++) {
            if (WEEKDAYS[i].equals(startDay)) {
                return i;
            }
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    private String getNextDay(String currentDay) {
        for (int i = 0; i < WEEKDAYS.length - 1; i++) {
            if (WEEKDAYS[i].equals(currentDay)) {
                return WEEKDAYS[i + 1];
            }
        }
        return WEEKDAYS[0];
    }

    private List<String> setDaysName(int days, String startDay) {
        List<String> daysName = new ArrayList<>();
        int startDayIndex = getStartDayIndex(startDay);

        for (int i = 0; i < days; i++) {
            daysName.add(WEEKDAYS[startDayIndex % WEEKDAYS.length]);
            startDayIndex++;
        }

        return daysName;
    }

    public List<String> getDaysName() {
        return daysName;
    }

    @Override
    public String toString() {
        return daysName.toString();
    }

}
