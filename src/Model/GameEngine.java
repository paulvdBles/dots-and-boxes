package Model;

import Controller.BoardController;
import Controller.GUIInitializer;
import Model.GameObjects.*;
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



}
