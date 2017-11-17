package Controller;

import Model.GameEngine;
import Model.GameObjects.BoardItem;
import Model.GameObjects.Box;
import Model.GameObjects.Dot;
import Model.GameObjects.Line;
import Model.Shapes.BoxShape;
import Model.Shapes.LineShape;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.util.List;


public class BoardController {

    @FXML
    private Scene primaryScene;

    @FXML
    private Pane boardPane;

    private GameEngine engine;

    public void setPrimaryScene(Scene primaryScene) {
        this.primaryScene = primaryScene;
    }

    public void lineClicked() {
        System.out.println("Click!");
    }

    public void setOnLineEntered(Rectangle line) {
        line.setFill(Color.valueOf(engine.getCurrentPlayerColour()));
        primaryScene.setCursor(Cursor.HAND);
    }

    public void setOnLineExited(Rectangle line) {
        line.setFill(Color.valueOf("#d0e1f2"));
        primaryScene.setCursor(Cursor.DEFAULT);
    }

    public void setEngine(GameEngine engine) {
        this.engine = engine;
    }

    public void addItem(Rectangle item){
        boardPane.getChildren().add(item);
    }
}
