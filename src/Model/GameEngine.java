package Model;

import Controller.BoardController;
import Controller.GUIInitializer;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul van der Bles on 9-8-2017.
 */
public class GameEngine {

    private GUIInitializer guiInitializer;
    private Stage primaryStage;
    private Board board;
    private BoardController boardController;

    public GameEngine(GUIInitializer guiInitializer, Stage primaryStage) {
        this.guiInitializer = guiInitializer;
        this.primaryStage = primaryStage;
        this.board = new Board();
        setupGame();
    }

    private void setupGame() {
        guiInitializer.initializeGUI(primaryStage, this);
    }

    public void setRows(int rows) {
        board.setRows(rows);
    }

    public int getRows() {
        return board.getRows();
    }

    public void setColumns(int columns) {
        board.setColumns(columns);
    }

    public int getColumns() {
        return board.getColumns();
    }

    public void startGame(Stage primaryStage, FXMLLoader loader) {
        boardController = loader.getController();
        List boardList = createBoardList(board.getColumns(), board.getRows());
        printList(boardList);
        primaryStage.show();
    }

    private List createBoardList(int columns, int rows) {
        List<List<Object>> boardList = new ArrayList<>();
        for (int currentRow = 0; currentRow <= (rows * 2); currentRow++) {
            List<Object> objectsRow = new ArrayList<>();
            for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
                addItemsToObjectRow(columns, currentRow, objectsRow, currentColumn);
            }
            boardList.add(objectsRow);
        }

        return boardList;
    }

    private void addItemsToObjectRow(int columns, int currentRow, List<Object> objectsRow, int currentColumn) {
        if ((currentRow & 1) == 0) {
            addDotsAndLines(columns, objectsRow, currentColumn);
        } else {
            addLinesAndBoxes(columns, objectsRow, currentColumn);
        }
    }

    private void addDotsAndLines(int columns, List<Object> objectsRow, int currentColumn) {
        objectsRow.add(new Dot());
        objectsRow.add(new Line());
        if (currentColumn == columns - 1) {
            objectsRow.add(new Dot());
        }
    }

    private void addLinesAndBoxes(int columns, List<Object> objectsRow, int currentColumn) {
        objectsRow.add(new Line());
        objectsRow.add(new Box());
        if (currentColumn == columns - 1) {
            objectsRow.add(new Line());
        }
    }

    private void printList(List<List<Object>> boardList){
        for (List<Object> objectRow: boardList) {
            StringBuilder sb = new StringBuilder();
            for (Object item : objectRow) {
                sb.append(item + " ");
            }
            System.out.println(sb);
        }
    }


}
