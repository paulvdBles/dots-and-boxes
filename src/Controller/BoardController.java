package Controller;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;


public class BoardController {

    @FXML
    private Scene primaryScene;

    @FXML
    private Text gameTitle;

    @FXML
    private Pane menuPane;

    @FXML
    private Pane boardPane;

    private int dots = 0;
    private int lines = 0;

    void setPrimaryScene(Scene primaryScene) {
        this.primaryScene = primaryScene;
    }

    private void createBoxAt(float positionX, float positionY) {
        Rectangle box = new Rectangle();
        box.setHeight(75);
        box.setWidth(75);
        box.setLayoutX(positionX);
        box.setLayoutY(positionY);
        box.setFill(Color.WHITE);
        box.setStroke(Color.BLACK);
        box.setStrokeType(StrokeType.INSIDE);
        boardPane.getChildren().add(box);
    }

    private void createDotAt(float positionX, float positionY) {
        Rectangle dot = new Rectangle();
        dot.setHeight(15);
        dot.setWidth(15);
        dot.setLayoutX(positionX);
        dot.setLayoutY(positionY);
        dot.setFill(Color.valueOf("#363b40"));
        dot.setStroke(Color.BLACK);
        dot.setStrokeType(StrokeType.INSIDE);
        boardPane.getChildren().add(dot);
        dots += 1;
    }

    private void createLineAt(float positionX, float positionY, String type) {
        Rectangle line = new Rectangle();

        if (type == "horizontal") {
            line.setHeight(15);
            line.setWidth(75);
        } else if (type == "vertical") {
            line.setHeight(75);
            line.setWidth(15);
        }

        line.setLayoutX(positionX + 14); // TODO: checken of dit moet?
        line.setLayoutY(positionY);
        line.setFill(Color.valueOf("#d0e1f2"));
        line.setOnMouseEntered(e -> setCursorHand());
        line.setOnMouseExited(e -> setCursorDefault());
        line.setStroke(Color.BLACK);
        line.setStrokeType(StrokeType.INSIDE);
        boardPane.getChildren().add(line);

        lines += 1;
    }

    private void getPositions(){
        // Deze controller moet echt bijhouden wat positie x en y zijn en wat er teruggegeven moet worden aan een dot, line en box
    }

    public void lineClicked() {
        System.out.println("Click!");
    }

    public void setCursorHand() {
        primaryScene.setCursor(Cursor.HAND);
    }

    public void setCursorDefault() {
        primaryScene.setCursor(Cursor.DEFAULT);
    }
}
