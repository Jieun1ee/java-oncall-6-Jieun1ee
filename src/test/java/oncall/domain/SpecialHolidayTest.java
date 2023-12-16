package oncall.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialHolidayTest {
    @DisplayName("1월 공휴일")
    @Test
    void testSpecialHolidayForJanuary() {
        SpecialHoliday specialHoliday = new SpecialHoliday(1);
        List<String> januaryHolidays = specialHoliday.getHoliday();
        assertEquals(1, januaryHolidays.size());
        assertEquals("1", januaryHolidays.get(0));
    }

    @DisplayName("3월 공휴일")
    @Test
    void testSpecialHolidayForMarch() {
        SpecialHoliday specialHoliday = new SpecialHoliday(3);
        List<String> marchHolidays = specialHoliday.getHoliday();
        assertEquals(1, marchHolidays.size());
        assertEquals("1", marchHolidays.get(0));
    }

    @DisplayName("5월 공휴일")
    @Test
    void testSpecialHolidayForMay() {
        SpecialHoliday specialHoliday = new SpecialHoliday(5);
        List<String> mayHolidays = specialHoliday.getHoliday();
        assertEquals(1, mayHolidays.size());
        assertEquals("5", mayHolidays.get(0));
    }

    @DisplayName("6월 공휴일")
    @Test
    void testSpecialHolidayForJune() {
        SpecialHoliday specialHoliday = new SpecialHoliday(6);
        List<String> juneHolidays = specialHoliday.getHoliday();
        assertEquals(1, juneHolidays.size());
        assertEquals("6", juneHolidays.get(0));
    }

    @DisplayName("8월 공휴일")
    @Test
    void testSpecialHolidayForAugust() {
        SpecialHoliday specialHoliday = new SpecialHoliday(8);
        List<String> augustHolidays = specialHoliday.getHoliday();
        assertEquals(1, augustHolidays.size());
        assertEquals("15", augustHolidays.get(0));
    }


    @DisplayName("10월 공휴일")
    @Test
    void testSpecialHolidayForOctober() {
        SpecialHoliday specialHoliday = new SpecialHoliday(10);
        List<String> octoberHolidays = specialHoliday.getHoliday();
        assertEquals(2, octoberHolidays.size());
        assertEquals("3", octoberHolidays.get(0));
        assertEquals("9", octoberHolidays.get(1));
    }

    @DisplayName("12월 공휴일")
    @Test
    public void testSpecialHolidayForDecember() {
        SpecialHoliday specialHoliday = new SpecialHoliday(12);
        List<String> decemberHolidays = specialHoliday.getHoliday();
        assertEquals(1, decemberHolidays.size());
        assertEquals("25", decemberHolidays.get(0));
    }
}