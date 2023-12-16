package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class WorkerOrder {
    private final String SATURDAY = "토";
    private final String SUNDAY = "일";

    private List<String> workers;

    public WorkerOrder(int days, List<String> daysName, List<String> weekdayWorker, List<String> holidayWorker) {
        this.workers = setWorkerOrder(days, daysName, weekdayWorker, holidayWorker);
    }

    private List<String> setWorkerOrder (int days, List<String> daysName, List<String> weekdayWorker, List<String> holidayWorker) {
        List<String> order = new ArrayList<>();
        int weekdayIndex = 0;
        int holidayIndex = 0;

        for (int i = 0; i < days; i++) {
            String day = daysName.get(i);

            if (!day.equals(SATURDAY) && !day.equals(SUNDAY)) {
                order.add(weekdayWorker.get(weekdayIndex % weekdayWorker.size()));
                weekdayIndex++;
                continue;
            }

            order.add(holidayWorker.get(holidayIndex % holidayWorker.size()));
            holidayIndex++;
        }

        return order;
    }

    public List<String> getWorkers() {
        return workers;
    }

    @Override
    public String toString() {
        return workers.toString();
    }
}
