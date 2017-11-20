package Model.GameObjects;

/**
 * Created by Paul van der Bles on 8-8-2017.
 */
public class Player {
    private int score;
    private String colourValue;
    private String name;

    public Player(String colourValue, String name) {
        this.colourValue = colourValue;
        this.name = name;
    }

    public String getColourValue() {
        return colourValue;
    }

    public void addPoints(int receivedPoints) {
        score += receivedPoints;
        System.out.println(name + " score: " + score);
    }
}
