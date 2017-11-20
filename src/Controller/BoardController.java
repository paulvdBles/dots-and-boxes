package Controller;

import Model.GameEngine;
import Model.GameObjects.Line;
import Model.GameObjects.Player;
import Model.Shapes.LineShape;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class BoardController {

    @FXML
    private Scene primaryScene;

    @FXML
    private Pane boardPane;

    @FXML
    private Text playerOnePoints;

    @FXML
    private Text playerTwoPoints;

    @FXML
    private Pane menuPane;

    @FXML
    private Text winMessage;

    private GameEngine engine;

    public void setPrimaryScene(Scene primaryScene) {
        this.primaryScene = primaryScene;
    }

    public void lineClicked(LineShape clickedLineShape) {
        if (!clickedLineShape.getLineObject().getFillStatus()) {
            clickedLineShape.setFill(Color.BLACK);
            primaryScene.setCursor(Cursor.DEFAULT);
            Line lineObject = clickedLineShape.getLineObject();
            engine.turn(lineObject);
        }
    }

    public void setOnLineEntered(LineShape line) {
        if (!line.getLineObject().getFillStatus()){
            line.setFill(Color.valueOf(engine.getCurrentPlayerColour()));
            primaryScene.setCursor(Cursor.HAND);
        }
    }

    public void setOnLineExited(LineShape line) {
        if (!line.getLineObject().getFillStatus()) {
            line.setFill(Color.valueOf("#d0e1f2"));
            primaryScene.setCursor(Cursor.DEFAULT);
        }
    }

    public void setEngine(GameEngine engine) {
        this.engine = engine;
    }

    public void addItem(Rectangle item){
        boardPane.getChildren().add(item);
    }

    public void changeScore(Player currentPlayer) {
        String newScoreText = currentPlayer.getScore() + " Points";
        if (currentPlayer.getName() == "Player 1"){
            playerOnePoints.setText(newScoreText);
        }
        else {
            playerTwoPoints.setText(newScoreText);
        }
    }

    public void setPanePosition(float positionY) {
        menuPane.setLayoutY(positionY + 10);
    }

    public void showWinner(Player currentPlayer) {
        winMessage.setText(currentPlayer.getName() + " wins!");
    }
}
