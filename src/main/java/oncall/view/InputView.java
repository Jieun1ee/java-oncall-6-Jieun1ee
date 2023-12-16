package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String WHAT_MONTH = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String WEEKDAY_WORKER = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String HOLIDAY_WORKER = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";

    public static String askMonth() {
        System.out.print(WHAT_MONTH);
        return Console.readLine();
    }

    public static String askWeekdayWorker() {
        System.out.print(WEEKDAY_WORKER);
        return Console.readLine();
    }

    public static String askHolidayWorker() {
        System.out.print(HOLIDAY_WORKER);
        return Console.readLine();
    }

}
