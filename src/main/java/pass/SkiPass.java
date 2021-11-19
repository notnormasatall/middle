package pass;


public abstract class SkiPass {
    private int ID;
    private boolean blocked = false;
    private boolean expired = false;

    public SkiPass(int ID) {
        this.ID = ID;
    }

    public boolean ifExpired() {
        return expired;
    }

    public boolean ifBlocked() {
        return blocked;
    }

    public void setBlocked() {
        this.blocked = true;
    }

    public void setExpired() {
        this.expired = true;
    }

    public abstract boolean usePass();
    public abstract boolean ifAvailable();
}
