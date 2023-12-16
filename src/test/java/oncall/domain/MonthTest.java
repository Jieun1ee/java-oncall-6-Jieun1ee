package oncall.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MonthTest {
    @DisplayName("1월부터 12월이 아닌 경우 에러처리")
    @Test
    void testNotMonth() {
        int num = 13;
        String startDay = "월";

        assertThrows(IllegalArgumentException.class, () -> new Month(num, startDay));
    }
    @DisplayName("월화수목금토일이 아닌 경우 에러처리")
    @Test
    void testNotDay() {
        int num = 12;
        String startDay = "헤";

        assertThrows(IllegalArgumentException.class, () -> new Month(num, startDay));
    }
}