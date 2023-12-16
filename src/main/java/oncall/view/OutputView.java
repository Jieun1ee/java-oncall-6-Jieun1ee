package oncall.view;

import java.util.List;

public class OutputView {
    public static void printResult(int month, int days, List<String> daysName, List<String> finalWorker,
                                   List<String> specialHoliday) {
        for (int i = 0; i < days; i++) {
            int day = i + 1;
            if (specialHoliday.contains(String.valueOf(day))) {
                System.out.println(month + "월 " + day + "일 " + daysName.get(i) + "(휴일) " + finalWorker.get(i));
                continue;
            }
            System.out.println(month + "월 " + day + "일 " + daysName.get(i) + " " + finalWorker.get(i));
        }
    }


    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
