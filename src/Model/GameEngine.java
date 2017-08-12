package Model;

/**
 * Created by Paul van der Bles on 9-8-2017.
 */
public class GameEngine {

    private int rows;
    private int columns;

    public void setupGame() {
        // game logica toevoegen
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setRows(int rows) {
        this.rows = rows;
        System.out.println("Aantal rows: " + rows);
    }

    public void setColumns(int columns) {
        this.columns = columns;
        System.out.println("Aantal columns: " + columns);
    }
}
