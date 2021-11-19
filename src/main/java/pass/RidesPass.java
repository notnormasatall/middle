package pass;

import constructors.PassType;
import constructors.RideType;
import lombok.Getter;

public class RidesPass extends Pass{
    @Getter
    private int ridesAvailable;
    private PassType type;


    public RidesPass(int ID, PassType type, RideType rides) {
        super(ID);
        this.type = type;
        this.ridesAvailable = rides.getLength();
    }

    @Override
    public boolean usePass() {
        if (ridesAvailable > 0) {
            ridesAvailable -= 1;
            return true;

        } else {
            return false;
        }
    }

    @Override
    public boolean ifReadyToUse() {
        return this.ridesAvailable > 0;
    }

    @Override
    public String toString() {
        return "RidesPass{" +
                "Type: " + type +
                ", Rides available: " + ridesAvailable +
                '}';
    }
}
