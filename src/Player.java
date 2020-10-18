import java.awt.*;

public class Player {
    private int health;
    private int charge;
    private int points;
    private int character;
    private int speed;
    private int velocity;
    private int hVelocity;
    private Point location;
    private String facing;
    private String moveState;
    private boolean isKicking;
    private boolean isDoingSpecial;


    public Player(int character) {
        health = Character.getHealth(character);
        charge = 0;
        speed = Character.getSpeed(character);
        points = 0;
        this.character = character;
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

    public int getCharacter() {
        return character;
    }

    public void setLocation(Point location) {
        if (location.y <= 250){
            this.location = location;
        } else {
            this.location = new Point(location.x, 250);
        }
    }

    public Point getLocation() {
        return location;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    public String getMoveState() {
        return moveState;
    }

    public void setMoveState(String moveState) {
        this.moveState = moveState;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int gethVelocity() {
        return hVelocity;
    }

    public void sethVelocity(int hVelocity) {
        this.hVelocity = hVelocity;
    }

    public boolean isDoingSpecial() {
        return isDoingSpecial;
    }

    public void setDoingSpecial(boolean doingSpecial) {
        isDoingSpecial = doingSpecial;
    }

    public boolean isKicking() {
        return isKicking;
    }

    public void setKicking(boolean kicking) {
        isKicking = kicking;
    }
}
