package system;

import constructors.*;

import lombok.Getter;
import pass.DaysPass;
import pass.HolidayPass;
import pass.Pass;
import pass.RidesPass;

import java.util.ArrayList;

public class PassSystem {
    @Getter
    private ArrayList<Pass> passes = new ArrayList<>();
    private int rejected = 0;
    private int accepted = 0;
    private int idCounter = 0;

    public PassSystem() {}


    public void createPass(PassType type, RideType ride) {
        Pass pass;
        pass = new RidesPass(idCounter, type, ride);
        addPass(pass);
        idCounter += 1;
    }

    public void createPass(PassType type, DayType day) {
        Pass pass;
        pass = new DaysPass(idCounter, day, type);
        addPass(pass);
        idCounter += 1;
    }

    public void createPass(PassType type) {
        Pass pass;
        pass = new HolidayPass(type, idCounter);
        addPass(pass);
        idCounter += 1;
    }

    public void addPass(Pass pass) {
        passes.add(pass);
    }

    public void addRejected() {
        rejected += 1;
    }

    public void addAccepted() {
        accepted += 1;
    }

    public void expireTicket(Pass pass) {
        pass.setExpired();
    }

    public void returnStat() {
        System.out.println(rejected);
        System.out.println(accepted);
    }
}
