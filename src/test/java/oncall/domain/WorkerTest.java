package oncall.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkerTest {
    @DisplayName("이름 중복인 경우에 에러처리")
    @Test
    void testNameDuplicate() {
        List<String> weekdayWorkers = Arrays.asList("준팍", "도밥", "고니", "수아", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리");
        List<String> holidayWorkers = Arrays.asList("수아", "수아", "글로", "솔로스타", "우코", "슬링키", "참새", "도리", "준팍", "도밥", "고니");

        assertThrows(IllegalArgumentException.class, () -> new Worker(weekdayWorkers, holidayWorkers));
    }

    @DisplayName("모든 이름이 다 같지 않을 경우 에러처리")
    @Test
    void testNoname() {
        List<String> weekdayWorkers = Arrays.asList("준팍", "도밥", "고니", "수아", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리");
        List<String> holidayWorkers = Arrays.asList("지니", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리", "준팍", "도밥", "고니");

        assertThrows(IllegalArgumentException.class, () -> new Worker(weekdayWorkers, holidayWorkers));
    }

    @DisplayName("평일 근무자의 수와 휴일 근무자의 수가 다른 경우 에러처리")
    @Test
    void testWorkersNumber() {
        List<String> weekdayWorkers = Arrays.asList("준팍", "도밥", "고니", "수아", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리");
        List<String> holidayWorkers = Arrays.asList("지니", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리", "준팍", "도밥", "고니");

        assertThrows(IllegalArgumentException.class, () -> new Worker(weekdayWorkers, holidayWorkers));
    }

    @DisplayName("이름이 5글자 이상인 사람이 존재하면 에러처리")
    @Test
    void testNameLength() {
        List<String> weekdayWorkers = Arrays.asList("준팍", "도밥", "고니", "저는이지은이에요", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리");
        List<String> holidayWorkers = Arrays.asList("저는이지은이에요", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리", "준팍", "도밥", "고니");

        assertThrows(IllegalArgumentException.class, () -> new Worker(weekdayWorkers, holidayWorkers));
    }

    @DisplayName("5명 이하면 에러처리")
    @Test
    void testNumberOfPeopleIsFive() {
        List<String> weekdayWorkers = Arrays.asList("준팍", "도밥", "고니", "수아");
        List<String> holidayWorkers = Arrays.asList("수아", "준팍", "도밥", "고니");

        assertThrows(IllegalArgumentException.class, () -> new Worker(weekdayWorkers, holidayWorkers));
    }


}