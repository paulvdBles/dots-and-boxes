package Model;

import Model.GameObjects.*;
import javafx.stage.Stage;

/**
 * Created by Paul van der Bles on 9-8-2017.
 */
public class GameEngine {

    private GUIInitializer guiInitializer;
    private Stage primaryStage;
    private Board board;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;

    public GameEngine(GUIInitializer guiInitializer, Stage primaryStage) {
        this.guiInitializer = guiInitializer;
        this.primaryStage = primaryStage;
        this.board = new Board();
        initializePlayers();
        startSetup();
    }

    private void initializePlayers() {
        playerOne = new Player("#ff1f1f");
        playerTwo = new Player("#1e90ff");
        currentPlayer = playerOne;
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

    public void turn(){
        // een object met een methode met heel veel methodes die checkt of er nu een box is
    }

    public String getCurrentPlayerColour() {
        return currentPlayer.getColourValue();
    }

}
