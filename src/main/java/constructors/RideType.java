package constructors;

import lombok.Getter;

@Getter
public enum RideType {
    LIFTS10(10), LIFTS20(20), LIFTS50(50), LIFTS100(100);
    private int length;

    RideType(int length) {
        this.length = length;
    }
}
