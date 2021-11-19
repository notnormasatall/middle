package system;

import lombok.Getter;
import pass.*;

public class Turnstile {

    @Getter
    private final PassSystem passSys = new PassSystem();

    public Turnstile() {}

    public boolean checkCard(Pass pass) {
        if (pass.ifExpired() || !pass.ifReadyToUse()) {
            passSys.addRejected();
            passSys.expireTicket(pass);
            System.out.println("This pass is not available!");
            return false;

        } else if (pass.ifBlocked()) {
            passSys.addRejected();
            return false;

        } else {
            pass.usePass();
            passSys.addAccepted();
            return true;
        }
    }
}
