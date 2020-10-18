import java.awt.*;

public class Player {
    private int health;
    private int charge;
    private int points;
    private int character;
    private Point location;


    public Player(int character) {
        health = 100;
        charge = 100;
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
        this.location = location;
    }

    public Point getLocation() {
        return location;
    }
}
