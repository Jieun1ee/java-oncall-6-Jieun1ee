package oncall.controller;

import java.util.ArrayList;
import java.util.List;
import oncall.OncallValidator;
import oncall.domain.Month;
import oncall.domain.Worker;
import oncall.utils.OncallUtils;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {
    public void run() {
        Month month = setMonth();
        Worker worker = setWorker();

    }

    private Month setMonth() {
        try {
            List<String> month = OncallUtils.splitWithComma(InputView.askMonth());
            return new Month(OncallValidator.checkInteger(month.get(0)), month.get(1));
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return setMonth();
        }
    }

    private List<String> setWeekdayWorker() {
        List<String> worker = new ArrayList<>();
        worker = OncallUtils.splitWithComma(InputView.askWeekdayWorker());
        OncallValidator.checkDuplicate(worker);
        return worker;
    }

    private List<String> setHolidayWorker() {
        List<String> worker = new ArrayList<>();
        worker = OncallUtils.splitWithComma(InputView.askHolidayWorker());
        OncallValidator.checkDuplicate(worker);
        return worker;
    }

    private Worker setWorker() {
        try {
            List<String> weekdayWorker = setWeekdayWorker();
            List<String> holidayWorker = setHolidayWorker();
            return new Worker(weekdayWorker, holidayWorker);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return setWorker();
        }
    }
}
