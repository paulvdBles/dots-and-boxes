package Model;

import Model.GameObjects.*;
import Model.Shapes.LineShape;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by Paul van der Bles on 9-8-2017.
 */
public class GameEngine {

    private GUIInitializer guiInitializer;
    private Stage primaryStage;
    private Board board;
    private List boardItems;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;

    void setRows(int rows) {
        board.setRows(rows);
    }

    int getRows() {
        return board.getRows();
    }

    void setColumns(int columns) {
        board.setColumns(columns);
    }

    int getColumns() {
        return board.getColumns();
    }

    void setBoardItems(List boardItems) {
        this.boardItems = boardItems;
    }

    public String getCurrentPlayerColour() {
        return currentPlayer.getColourValue();
    }

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

    public void turn(LineShape line){
        System.out.println(line);
        // een object met een methode met heel veel methodes die checkt of er nu een box is
    }
}
