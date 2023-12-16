package oncall.domain;

import java.util.List;
import oncall.OncallValidator;

public class Worker {

    public Worker(List<String> weekdayWorker, List<String> holidayWorker) {
        OncallValidator.checkWorker(weekdayWorker, holidayWorker);
    }
}
