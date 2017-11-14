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
        startSetup();
    }

    private void startSetup() {
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

    public void configureBoardItems(Stage primaryStage, FXMLLoader loader) {
        boardController = loader.getController();
        List listOfBoardItems = createListOfBoardItems(board.getColumns(), board.getRows());
        attachBoxesToLines(listOfBoardItems);
        printList(listOfBoardItems); // for test purposes
        primaryStage.show();
        // hier het starten van een ronde
    }

    private List createListOfBoardItems(int columns, int rows) {
        List<List<BoardItem>> boardList = new ArrayList<>();
        for (int currentRow = 0; currentRow <= (rows * 2); currentRow++) {
            List<BoardItem> objectsRow = new ArrayList<>();
            for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
                addItemsToBoardRow(columns, currentRow, objectsRow, currentColumn);
            }
            boardList.add(objectsRow);
        }
        return boardList;
    }

    private void addItemsToBoardRow(int columns, int currentRow, List<BoardItem> objectsRow, int currentColumn) {
        if ((currentRow & 1) == 0) {
            addDotsAndLines(columns, objectsRow, currentColumn);
        } else {
            addLinesAndBoxes(columns, objectsRow, currentColumn);
        }
    }

    private void addDotsAndLines(int columns, List<BoardItem> objectsRow, int currentColumn) {
        objectsRow.add(new Dot());
        objectsRow.add(new Line());
        if (currentColumn == columns - 1) {
            objectsRow.add(new Dot());
        }
    }

    private void addLinesAndBoxes(int columns, List<BoardItem> objectsRow, int currentColumn) {
        objectsRow.add(new Line());
        objectsRow.add(new Box());
        if (currentColumn == columns - 1) {
            objectsRow.add(new Line());
        }
    }

    private void attachBoxesToLines(List<List<BoardItem>> listOfBoardItems) {
        for (List<BoardItem> rowOfBoardItems : listOfBoardItems) {
            for (BoardItem item : rowOfBoardItems) {
                if (item instanceof Box) {
                    int indexOfRow = listOfBoardItems.indexOf(rowOfBoardItems);
                    int indexOfBox = rowOfBoardItems.indexOf(item);

                    Line northernLine = findAssociatedNorthernLine(listOfBoardItems, indexOfRow, indexOfBox);
                    Line easternLine = findAssociatedEasternLine(rowOfBoardItems, indexOfBox);
                    Line southernLine = findAssociatedSouthernLine(listOfBoardItems, indexOfRow, indexOfBox);
                    Line westernLine = findAssociatedWesternLine(rowOfBoardItems, indexOfBox);

                    ((Box) item).setAssociatedLines(northernLine, easternLine, southernLine, westernLine);
                }
            }
        }
    }

    private Line findAssociatedNorthernLine(List<List<BoardItem>> listOfBoardItems, int indexOfRow, int indexOfBox) {
        int targetRowIndex = indexOfRow - 1;
        List<BoardItem> rowThatContainsLine = listOfBoardItems.get(targetRowIndex);
        Line northernLine = (Line) rowThatContainsLine.get(indexOfBox); // the line should be on the same index as the box, but in a higher row
        return northernLine;
    }

    private Line findAssociatedEasternLine(List<BoardItem> rowThatContainsLine, int indexOfBox) {
        int targetLineIndex = indexOfBox + 1;
        Line easternLine = (Line) rowThatContainsLine.get(targetLineIndex);
        return easternLine;
    }

    private Line findAssociatedSouthernLine(List<List<BoardItem>> listOfBoardItems, int indexOfRow, int indexOfBox) {
        int targetRowIndex = indexOfRow + 1;
        List<BoardItem> rowThatContainsLine = listOfBoardItems.get(targetRowIndex);
        Line southernLine = (Line) rowThatContainsLine.get(indexOfBox); // the line should be on the same index as the box, but in a higher row
        return southernLine;
    }

    private Line findAssociatedWesternLine(List<BoardItem> rowThatContainsLine, int indexOfBox) {
        int targetLineIndex = indexOfBox - 1;
        Line westernLine = (Line) rowThatContainsLine.get(targetLineIndex);
        return westernLine;
    }

    private void printList(List<List<Object>> boardList) {
        for (List<Object> objectRow : boardList) {
            StringBuilder sb = new StringBuilder();
            for (Object item : objectRow) {
                sb.append(item + " ");
            }
            System.out.println(sb);
        }
    }


}
