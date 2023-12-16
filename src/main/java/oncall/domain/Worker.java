package oncall.domain;

import java.util.List;
import oncall.OncallValidator;

public class Worker {
    private List<String> weekdayWorker;
    private List<String> holidayWorker;


    public Worker(List<String> weekdayWorker, List<String> holidayWorker) {
        OncallValidator.checkWorker(weekdayWorker, holidayWorker);
        this.weekdayWorker = weekdayWorker;
        this.holidayWorker = holidayWorker;
    }

    public List<String> getWeekdayWorker() {
        return weekdayWorker;
    }

    public List<String> getHolidayWorker() {
        return holidayWorker;
    }
}
