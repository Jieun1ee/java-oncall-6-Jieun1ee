package oncall.controller;

import java.util.ArrayList;
import oncall.domain.Calendar;
import java.util.List;
import oncall.OncallValidator;
import oncall.domain.DaysName;
import oncall.domain.Month;
import oncall.domain.SpecialHoliday;
import oncall.domain.Worker;
import oncall.domain.WorkerOrder;
import oncall.utils.OncallUtils;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {
    public void run() {
        Month month = setMonth();
        Worker worker = setWorker();
        int days = getDaysInMonth(month.getMonth());
        DaysName daysName = setDaysName(days, month.getStartDay());
        SpecialHoliday specialHoliday = setSpecialHoliday(month.getMonth());
        WorkerOrder workerOrder = setOrder(days, daysName.getDaysName(), worker.getWeekdayWorker(),
                worker.getHolidayWorker(), specialHoliday.getHoliday());
        printResult(month.getMonth(), days, daysName.getDaysName(), workerOrder.getWorkers(),
                specialHoliday.getHoliday());
        System.out.println(specialHoliday.getHoliday().get(0));
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

    private Integer getDaysInMonth(int month) {
        for (Calendar calendar : Calendar.values()) {
            if (calendar.month == month) {
                return calendar.daysNumber;
            }
        }
        return null;
    }

    private DaysName setDaysName(int days, String startDay) {
        return new DaysName(days, startDay);
    }

    private WorkerOrder setOrder(int days, List<String> daysName, List<String> weekdayWorker,
                                 List<String> holidayWorker, List<String> specialHoliday) {
        return new WorkerOrder(days, daysName, weekdayWorker, holidayWorker, specialHoliday);
    }

    private SpecialHoliday setSpecialHoliday(int month) {
        return new SpecialHoliday(month);
    }

    private void printResult(int month, int days, List<String> daysName, List<String> finalWorker, List<String> specialHoliday) {
        OutputView.printResult(month, days, daysName, finalWorker, specialHoliday);
    }
}
