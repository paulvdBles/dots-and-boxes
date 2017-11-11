package Controller;

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

    public void drawBoard(int columns, int rows) {
        float positionX = 5;
        float positionY = 5;

        // draw the dots on the board
        for (int currentRow = 0; currentRow <= rows; currentRow++) {
            for (int currentColumn = 0; currentColumn <= columns; currentColumn++) {
                    createDotAt(positionX, positionY);
                    positionX += 88;
            }
            positionX -= (88 * (columns + 1));
            positionY += 88;
        }
        System.out.println("Drawed dots: " + dots);
        System.out.println("Drawed lines: " + lines);

        // draw the lines on the board

    }

    private void createInnerCubeAt(float positionX, float positionY) {
        // the inner cube you know
    }

    private void createDotAt(float positionX, float positionY) {
        Rectangle dot = new Rectangle();

        dot.setHeight(15);
        dot.setWidth(15);
        dot.setLayoutX(positionX); // so it went 88 places to the right
        dot.setLayoutY(positionY);
        dot.setFill(Color.valueOf("#363b40"));

        boardPane.getChildren().add(dot);

        dots += 1;
    }

    private void createLineAt(float positionX, float positionY, boolean horizontal) {
        Rectangle line = new Rectangle();

        if (horizontal) {
            line.setHeight(15);
            line.setWidth(75);
        } else {
            line.setHeight(75);
            line.setWidth(15);
        }

        line.setLayoutX(positionX + 14); // so it went 88 places to the right
        line.setLayoutY(positionY);
        line.setFill(Color.valueOf("#d0e1f2"));

        boardPane.getChildren().add(line);

        lines += 2;
    }

    public void lineClicked() {
        System.out.println("Click!");
    }

    public void setCursorHandOnMouseEntered() {
        primaryScene.setCursor(Cursor.HAND);
    }

    public void setCursorDefaultOnMouseEntered() {
        primaryScene.setCursor(Cursor.DEFAULT);
    }


}
