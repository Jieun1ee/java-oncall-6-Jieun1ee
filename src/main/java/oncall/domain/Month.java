package oncall.domain;

import oncall.OncallValidator;

public class Month {
    private final Integer month;
    private final String startDay;

    public Month(Integer month, String startDay) {
        this.month = OncallValidator.checkMonth(month);
        this.startDay = OncallValidator.checkStartDay(startDay);
    }

    public Integer getMonth() {
        return month;
    }

    public String getStartDay() {
        return startDay;
    }
}
