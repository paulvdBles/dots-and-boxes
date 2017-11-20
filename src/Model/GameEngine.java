package Model;

import Model.GameObjects.*;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by Paul van der Bles on 9-8-2017.
 */
public class GameEngine {

    private GUIInitializer guiInitializer;
    private Stage primaryStage;
    private Board board;
    private List<List<BoardItem>> boardItems;
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
        playerOne = new Player("#ff1f1f", "Player 1");
        playerTwo = new Player("#1e90ff", "Player 2");
        currentPlayer = playerOne;
    }

    private void startSetup() {
        guiInitializer.initializeGUI(primaryStage, this);
    }

    public void turn(Line clickedLine) {
        clickedLine.setFillStatus(true);
        int attachedBoxes = clickedLine.howManyAttachedBoxesAreFilledSinceThisTurn();
        currentPlayer.addPoints(attachedBoxes * 10);
        if (checkIfAllBoxesAreFilled()){
            // stop spel ofzo
        }
        else {
            currentPlayer = changePlayer();
        }
        // iets dat checkt of er nu een box is ingevuld

    }

    private boolean checkIfAllBoxesAreFilled() { // hier maak ik een methode van die checkt of alle boxen gevuld zijn
        for (List<BoardItem> rowOfBoardItems : boardItems) {
            for (BoardItem item : rowOfBoardItems) {
                if (item instanceof Box) {
                    if (!((Box) item).shouldBeFilled()) {
                        return false;
                    }

                }
            }
        }
        return true;
    }

    private Player changePlayer() {
        if (currentPlayer.equals(playerOne)) {
            return playerTwo;
        } else {
            return playerOne;
        }
    }
}
