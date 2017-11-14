package Model;

/**
 * Created by Paul van der Bles on 8-8-2017.
 */
public class Box implements BoardItem {
    private Line northernLine;
    private Line easternLine;
    private Line southernLine;
    private Line westernLine;

    @Override
    public String toString() {
        return "Box";
    }

    public void setAssociatedLines(Line northernLine, Line easternLine, Line southernLine, Line westernLine) {
        this.northernLine = northernLine;
        this.easternLine = easternLine;
        this.southernLine = southernLine;
        this.westernLine = westernLine;
    }
}
