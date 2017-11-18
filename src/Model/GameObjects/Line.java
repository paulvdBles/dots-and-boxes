package Model.GameObjects;

/**
 * Created by Paul van der Bles on 8-8-2017.
 */
public class Line implements BoardItem {
    private boolean filled;

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Line";
    }
}
