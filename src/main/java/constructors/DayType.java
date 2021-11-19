package constructors;

import lombok.Getter;

@Getter
public enum DayType {
    DAYS1(1), DAYS2(2), DAYS5(5);
    private int length;

    DayType(int length) {
        this.length = length;
    }
}
