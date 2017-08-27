package Model;

public class Board {

    private int rows;
    private int columns;

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
