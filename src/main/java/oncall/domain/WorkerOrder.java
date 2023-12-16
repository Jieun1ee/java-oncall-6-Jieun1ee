package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class WorkerOrder {
    private final String SATURDAY = "토";
    private final String SUNDAY = "일";

    private List<String> workers;

    public WorkerOrder(int days, List<String> daysName, List<String> weekdayWorker, List<String> holidayWorker,
                       List<String> specialHoliday) {
        this.workers = setWorkerOrder(days, daysName, weekdayWorker, holidayWorker, specialHoliday);
    }

    private List<String> setWorkerOrder(int days, List<String> daysName, List<String> weekdayWorker,
                                        List<String> holidayWorker, List<String> specialHoliday) {
        List<String> order = new ArrayList<>();
        int weekdayIndex = 0;
        int holidayIndex = 0;

        for (int i = 0; i < days; i++) {
            String day = daysName.get(i);

            boolean isWeekday = !day.equals(SATURDAY) && !day.equals(SUNDAY) && !specialHoliday.contains(String.valueOf(i + 1));

            if (isWeekday) {
                checkContinuity(order, weekdayWorker, weekdayIndex);
                order.add(weekdayWorker.get(weekdayIndex % weekdayWorker.size()));
                weekdayIndex++;
            }

            if (!isWeekday) {
                checkContinuity(order, holidayWorker, holidayIndex);
                order.add(holidayWorker.get(holidayIndex % holidayWorker.size()));
                holidayIndex++;
            }
        }
        return order;
    }

    private void checkContinuity(List<String> order, List<String> worker, int index) {
        if (order.size() > 1 && worker.get(index % worker.size()).equals(order.get(order.size() - 1))) {
            swap(worker, index % worker.size());
        }
    }

    private void swap(List<String> list, int index) {
        String temp = list.get(index);
        list.set(index, list.get(index + 1));
        list.set(index + 1, temp);
    }


//    private List<String> setWorkerOrder(int days, List<String> daysName, List<String> weekdayWorker,
//                                        List<String> holidayWorker, List<String> specialHoliday) {
//        List<String> order = new ArrayList<>();
//        int weekdayIndex = 0;
//        int holidayIndex = 0;
//
//        for (int i = 0; i < days; i++) {
//            String day = daysName.get(i);

//            boolean isWeekday = !day.equals(SATURDAY) && !day.equals(SUNDAY) && !specialHoliday.contains(String.valueOf(i + 1));
//
//            if (isWeekday) {
//                checkContinuity(order, weekdayWorker, weekdayIndex);
//                order.add(weekdayWorker.get(weekdayIndex % weekdayWorker.size()));
//                weekdayIndex++;
//            }
//
//            if (!isWeekday) {
//                checkContinuity(order, holidayWorker, holidayIndex);
//                order.add(holidayWorker.get(holidayIndex % holidayWorker.size()));
//                holidayIndex++;
//            }
//        }
//        return order;
//    }

//    private void checkContinuity(List<String> order, List<String> worker, int index) {
//        if (index >= 1 && index < order.size()) {
//            if (worker.get(index % worker.size()).equals(order.get(order.size() - 1))) {
//                swap(worker, index);
//            }
//        }
//    }
//
//    private void swap(List<String> list, int index) {
//        String temp = list.get(index);
//        list.set(index, list.get(index + 1));
//        list.set(index + 1, temp);
//    }

    public List<String> getWorkers() {
        return workers;
    }

    @Override
    public String toString() {
        return workers.toString();
    }
}
