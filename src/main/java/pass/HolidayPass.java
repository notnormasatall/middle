package pass;

import constructors.PassType;

import java.util.Calendar;
import java.util.Date;

public class HolidayPass extends Pass{
    private final Date holidayEnd = new Date(18, Calendar.NOVEMBER,18);
    private PassType type;

    public HolidayPass(PassType type, int ID) {
        super(ID);
        this.type = type;
    }


    @Override
    public boolean usePass() {
        Date currentDate = new Date();

        return !currentDate.equals(holidayEnd);
    }

    @Override
    public boolean ifReadyToUse() {
        Date currDate = new Date();
        return dayDifference(holidayEnd, currDate) < 0;
    }

    private int dayDifference(Date dateOne, Date dateTwo) {

        long dateOneInMs = dateOne.getTime();
        long dateTwoInMs = dateTwo.getTime();

        long timeDiff = dateTwoInMs - dateOneInMs;

        return (int) (timeDiff / (1000 * 60 * 60* 24));
    }

    @Override
    public String toString() {
        return "HolidayPass{" +
                "Type: " + type +
                ", endDate :" + holidayEnd +
                '}';
    }
}
