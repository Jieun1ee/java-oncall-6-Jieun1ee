package oncall.domain;

public enum Calender {
    JANUARY(1, 31),
    FEBRARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31);

    public final Integer month;
    public final Integer daysNumber;

    Calender(int month, int daysNumber) {
        this.month = month;
        this.daysNumber = daysNumber;
    }

    public Integer getDaysNumber() {
        return daysNumber;
    }
}
