package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class SpecialHoliday {
    private List<String> holiday;

    public SpecialHoliday(int month) {
        this.holiday = setHoliday(month);
    }

    private List<String> setHoliday(int month) {
        List<String> holidays = new ArrayList<>();
        if (month == 1) {
            holidays.add("1");
            return holidays;
        }
        if (month == 3) {
            holidays.add("1");
            return holidays;
        }
        if (month == 5) {
            holidays.add("5");
            return holidays;
        }
        if (month == 6) {
            holidays.add("6");
            return holidays;
        }
        if (month == 8) {
            holidays.add("15");
            return holidays;
        }
        if (month == 10) {
            holidays.add("3");
            holidays.add("9");
            return holidays;
        }
        if (month == 12) {
            holidays.add("25");
            return holidays;
        }
        return null;
    }

    public List<String> getHoliday() {
        return holiday;
    }
}
