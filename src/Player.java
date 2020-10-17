public class Player {
    private int health;
    private int charge;
    private int points;

    public final static int PURDUE_PETE = 0;
    public final static int HERKY_THE_HAWKEYE = 1;
    public final static int BUCKY_THE_BADGER = 2;
    public final static int HOOSIER = 3;
    public final static int BRUTUS_THE_BUCKEYE = 4;
    public final static int SPARTY_THE_SPARTAN = 5;

    public Player() {
        health = 100;
        charge = 100;
        points = 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
