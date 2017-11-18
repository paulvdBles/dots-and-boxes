package Controller;

import Model.GameEngine;
import Model.Shapes.LineShape;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardController {

    @FXML
    private Scene primaryScene;

    @FXML
    private Pane boardPane;

    private GameEngine engine;

    public void setPrimaryScene(Scene primaryScene) {
        this.primaryScene = primaryScene;
    }

    public void lineClicked(LineShape line) {
        if (!line.getLineObject().isFilled()) {
            line.setFill(Color.BLACK);
            primaryScene.setCursor(Cursor.DEFAULT);
            engine.turn(line);
        }
    }

    public void setOnLineEntered(LineShape line) {
        if (!line.getLineObject().isFilled()){
            line.setFill(Color.valueOf(engine.getCurrentPlayerColour()));
            primaryScene.setCursor(Cursor.HAND);
        }
    }

    public void setOnLineExited(LineShape line) {
        if (!line.getLineObject().isFilled()) {
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
}
