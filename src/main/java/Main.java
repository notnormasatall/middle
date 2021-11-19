import constructors.*;
import system.Turnstile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        process();
    }

    public static boolean process() {

        Turnstile turnstile = new Turnstile();
        Scanner sc = new Scanner(System.in);

        System.out.println("On which day do you want to visit us?");
        System.out.println("Weekday: WD | Weekend: WN | Holidays: HD");

        String choice;
        choice = sc.nextLine();

        PassType type;

        if (choice.equals("HD")) {
            type = PassType.HOLIDAY;
            turnstile.getPassSys().createPass(PassType.HOLIDAY);
            System.out.println(turnstile.getPassSys().getPasses());
            return true;

        } else if (choice.equals("WD")) {
            type = PassType.WEEKDAY;
        } else {
            type = PassType.WEEKEND;
        }

        System.out.println("Do you want a 'rides' or 'days' pass?");
        System.out.println("Days: D | Rides: R");

        choice = sc.nextLine();
        int[] nums;

        if (choice.equals("D")) {
            nums = new int[]{1, 2, 5};

            List<DayType> choices = Arrays.asList(DayType.DAYS1, DayType.DAYS2, DayType.DAYS5);

            System.out.println("Now choose number of days:");
            for (int i: nums) {
                System.out.println("Print " + i + " for " + i);
            }

            int choiceInt = sc.nextInt();
            DayType dayType = filterDay(choices, choiceInt);

            turnstile.getPassSys().createPass(type, dayType);
            System.out.println(turnstile.getPassSys().getPasses());

        } else {
            nums = new int[]{10, 20, 50, 100};

            List<RideType> choices = Arrays.asList(RideType.LIFTS10, RideType.LIFTS20, RideType.LIFTS50, RideType.LIFTS100);

            System.out.println("Now choose number of rides:");
            for (int i: nums) {
                System.out.println("Print " + i + " for " + i);
            }

            int choiceInt = sc.nextInt();
            RideType rideType = filterRide(choices, choiceInt);

            turnstile.getPassSys().createPass(type, rideType);
            System.out.println(turnstile.getPassSys().getPasses());
        }
        return true;

    }

    public static DayType filterDay(List<DayType> data, int numerator) {
        ArrayList<DayType> result = new ArrayList<>();

        for (DayType el : data) {
            if (el.getLength()==numerator) {
                result.add(el);
            }
        }

        return result.get(0);
    }

    public static RideType filterRide(List<RideType> data, int numerator) {
        ArrayList<RideType> result = new ArrayList<>();

        for (RideType el : data) {
            if (el.getLength()==numerator) {
                result.add(el);
            }
        }

        return result.get(0);
    }
}
