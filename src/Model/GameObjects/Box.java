package Model.GameObjects;

/**
 * Created by Paul van der Bles on 8-8-2017.
 */
public class Box implements BoardItem {
    private boolean fillStatus;

    private Line northernLine;
    private Line easternLine;
    private Line southernLine;
    private Line westernLine;

    public void setLinesRelationship(Line northernLine, Line easternLine, Line southernLine, Line westernLine) {
        setAssociatedLines(northernLine, easternLine, southernLine, westernLine);

        northernLine.addAttachedBoxes(this);
        easternLine.addAttachedBoxes(this);
        southernLine.addAttachedBoxes(this);
        westernLine.addAttachedBoxes(this);
    }

    public void setAssociatedLines(Line northernLine, Line easternLine, Line southernLine, Line westernLine) {
        this.northernLine = northernLine;
        this.easternLine = easternLine;
        this.southernLine = southernLine;
        this.westernLine = westernLine;
    }

    public boolean isAlreadyFilled() {
        return fillStatus;
    }

    public boolean shouldBeFilled() {
        fillStatus = northernLine.getFillStatus() && easternLine.getFillStatus() && southernLine.getFillStatus() && westernLine.getFillStatus();
        return fillStatus;
    }

}
