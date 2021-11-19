package pass;

import constructors.DayType;
import constructors.PassType;
import lombok.Getter;

import java.util.Date;

public class DaysPass extends Pass{
    @Getter
    private PassType type;
    private int daysAvailable;
    private final Date startTrial;

    @Override
    public String toString() {
        return "DaysPass{" +
                "Type " + type +
                ", Days available: " + daysAvailable +
                ", Start of trial: " + startTrial +
                '}';
    }

    public DaysPass(int ID, DayType days, PassType type) {
        super(ID);
        this.type = type;

        if (type.equals(PassType.WEEKEND)) {
            this.daysAvailable = Math.min(days.getLength(), DayType.DAYS2.getLength());
        } else {
            this.daysAvailable = days.getLength();
        }
        this.startTrial = new Date();
    }

    @Override
    public boolean usePass() {
        Date currentDate = new Date();

        if (dayDifference(startTrial, currentDate) <= daysAvailable) {
            daysAvailable -= dayDifference(startTrial, currentDate);
            return true;
        } else {

            return false;
        }
    }

    @Override
    public boolean ifReadyToUse() {
        return daysAvailable > 0;
    }

    private int dayDifference(Date dateOne, Date dateTwo) {

        long dateOneInMs = dateOne.getTime();
        long dateTwoInMs = dateTwo.getTime();

        long timeDiff = dateTwoInMs - dateOneInMs;

        return (int) (timeDiff / (1000 * 60 * 60* 24));
    }
}
