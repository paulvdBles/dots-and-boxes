package Model;

import Controller.BoardController;
import Controller.GUIInitializer;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

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

    public void setupGame() {
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
        // write something that sets the right amount of rows and lines
        boardController = loader.getController();
        boardController.drawBoard(board.getColumns(), board.getRows());
        primaryStage.show();
    }
}
