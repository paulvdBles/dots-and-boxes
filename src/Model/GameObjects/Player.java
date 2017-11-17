package Model.GameObjects;

/**
 * Created by Paul van der Bles on 8-8-2017.
 */
public class Player {
    private int score;
    private String colourValue;

    public Player(String colourValue) {
        this.colourValue = colourValue;
    }

    public String getColourValue() {
        return colourValue;
    }
}
