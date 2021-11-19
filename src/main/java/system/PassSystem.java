package system;

import constructors.*;

import lombok.Getter;
import pass.DaysPass;
import pass.HolidayPass;
import pass.SkiPass;
import pass.RidesPass;

import java.util.ArrayList;

public class PassSystem {
    @Getter
    private ArrayList<SkiPass> passes = new ArrayList<>();
    private int rejected = 0;
    private int accepted = 0;
    private int overallOperations = 0;
    private int idCounter = 0;

    public PassSystem() {}

//    following methods needed to receive different types of passes|attributes
    public void createPass(PassType type, RideType ride) {
        SkiPass pass;
        pass = new RidesPass(idCounter, type, ride);
        addPass(pass);
        idCounter += 1;
    }

    public void createPass(PassType type, DayType day) {
        SkiPass pass;
        pass = new DaysPass(idCounter, day, type);
        addPass(pass);
        idCounter += 1;
    }

    public void createPass(PassType type) {
        SkiPass pass;
        pass = new HolidayPass(type, idCounter);
        addPass(pass);
        idCounter += 1;
    }

    public void addPass(SkiPass pass) {
        passes.add(pass);
    }

//    +1 if pass not accepted by the turnstile
    public void addRejected() {
        overallOperations += 1;
        rejected += 1;
    }

//    +1 if pass accepted by the turnstile
    public void addAccepted() {
        overallOperations += 1;
        accepted += 1;
    }

    public void expireTicket(SkiPass pass) {
        pass.setExpired();
    }

//    provides statistics of how many passes are rejected|accepted
    public void returnStat() {
        System.out.println("Rejected:");
        System.out.println(rejected/overallOperations + "%");
        System.out.println("Accepted:");
        System.out.println(accepted/overallOperations + "%");
    }
}
